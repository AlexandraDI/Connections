package servlets.navigation;

import dao.UserDAOImpl;
import dao.UserIsConnectedToUserDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Article;
import model.Reaction;
import model.User;
import model.UserIsConnectedToUser;

/**
 *
 * @author alex
 */
@WebServlet(name = "FriendRequestServlet", urlPatterns = {"/friendrequest"})
public class FriendRequestServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        User me = (User) request.getSession(false).getAttribute("me");

        
        UserDAOImpl udao =new UserDAOImpl();

        List<UserIsConnectedToUser> connections= new ArrayList<>();
        List<User> users= new ArrayList<>();
        List<User> not= new ArrayList<>();
        //List<User> notconnected;
  
        
        List<UserIsConnectedToUser> networkList;
        List<UserIsConnectedToUser> networkList1;

       
        UserIsConnectedToUserDAOImpl dao3 = new UserIsConnectedToUserDAOImpl();

        networkList = dao3.find(me.getUserId());
        networkList1 = dao3.find2(me.getUserId());
        connections.addAll(networkList);
        connections.addAll(networkList1);
        
        users  = udao.list();
        if (!(connections == null)) {
            //for()
            for (UserIsConnectedToUser list : networkList) {
                        // if(list.getUser().equals(users.getUserId())){                        
                        //     users.remove(list.getUser());
                         //}
            }            
            
        } 
        
        Integer connecteduserId;
        //Ta syndedemena arthra
        if (!(networkList == null)) {
            for (UserIsConnectedToUser nlist : networkList) {

                connecteduserId = nlist.getUser1().getUserId();
                //out.println("<p>- " + u.getFirstname()+ " " + u.getSurname()+ " " + u.getPassword() + " </p>");

                for (User user : users) {
                    if ((user.getUserId().equals(connecteduserId))) {
                        not.add(user);
                    } else {
                        if ((user.getUserId().equals(me.getUserId()))) {
                            //conarticlelist.add(article);
                        }
                    }
                }
            }
        }
        if (!(networkList1 == null)) {
            for (UserIsConnectedToUser nlist1 : networkList1) {

                connecteduserId = nlist1.getUser().getUserId();

                for (User user : users) {
                    if (user.getUserId().equals(connecteduserId)) {
                        not.add(user);
                    } else {
                        if ((user.getUserId().equals(me.getUserId()))) {
                            //conarticlelist.add(article);
                        }
                    }
                }
            }
        }        
        users.removeAll(not);
        
        users.remove(me);         
        //Akomh ena remove gia ton administrator
        //users.remove()
      
        request.getSession(false).setAttribute("notconnectedusers", users);
        request.setAttribute("notconnectedusers", users);         
        
        String nextJSP = "/WEB-INF/complete/friendrequest.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}