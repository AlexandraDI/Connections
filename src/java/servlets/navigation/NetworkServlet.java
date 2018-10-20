package servlets.navigation;

import dao.UserIsConnectedToUserDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UserIsConnectedToUser;
import model.User;

/**
 *
 * @author alex
 */
@WebServlet(name = "NetworkServlet", urlPatterns = {"/network"})
public class NetworkServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        //HttpSession session = request.getSession();
        
        User me = (User) request.getSession(false).getAttribute("me");
        
        List<UserIsConnectedToUser> networkList;
        List<UserIsConnectedToUser> networkList1;
        /*networkList = (List<UserIsConnectedToUser>) request.getSession(false).getAttribute("networkList");
        networkList1 = (List<UserIsConnectedToUser>) request.getSession(false).getAttribute("networkList1");*/
        
        User userdetail;
        
        UserIsConnectedToUserDAOImpl dao3 = new UserIsConnectedToUserDAOImpl();

        networkList = dao3.find(me.getUserId());
        networkList1 = dao3.find2(me.getUserId());
        
        //request.getSession(false).setAttribute("networkList", networkList);
        //request.getSession(false).setAttribute("networkList1", networkList1);
        
        
        request.setAttribute("networkList", networkList); 
        request.setAttribute("networkList1", networkList1);

        
        
        String nextJSP = "/WEB-INF/complete/network.jsp";
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
