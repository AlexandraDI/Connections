package servlets.navigation;

import dao.AdDAOImpl;
import dao.UserApplyAdDAOImpl;
import dao.UserDAOImpl;
import dao.UserIsConnectedToUserDAOImpl;
import dao.definitions.AdDAO;
import dao.definitions.UserApplyAdDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Ad;
import model.UserApplyAd;
import model.User;
import model.Job;
import model.UserIsConnectedToUser;

/**
 *
 * @author alex
 */
@WebServlet(name = "ExamineDetails1", urlPatterns = {"/examinedetails1"})
public class ExamineDetails1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        Integer adid = Integer.parseInt(request.getParameter("id").toString());  
        
        User me = (User) request.getSession(false).getAttribute("me");
        
        AdDAOImpl addao = new AdDAOImpl();       
        Ad ad = addao.find(adid);       
        
        List<UserApplyAd> useradlist;
        //List<UserIsConnectedToUser> networkList1;
        /*networkList = (List<UserIsConnectedToUser>) request.getSession(false).getAttribute("networkList");
        networkList1 = (List<UserIsConnectedToUser>) request.getSession(false).getAttribute("networkList1");*/
        
        User userdetail;
        UserApplyAdDAOImpl uadao = new UserApplyAdDAOImpl();

        useradlist = uadao.findUserAds(ad.getAdId());
        //networkList1 = dao3.find2(me.getUserId());
       
        //AdDAOImpl adao = new AdDAOImpl();

        //List<Ad> adlist = adao.list();
        List<UserApplyAd> mylist = new ArrayList<>();

        Integer connecteduserId;

        if (!(useradlist == null)) {
            //for (UserApplyAd nlist : useradlist) {

                //connecteduserId = nlist.getUser1().getUserId();
                //out.println("<p>- " + u.getFirstname()+ " " + u.getSurname()+ " " + u.getPassword() + " </p>");

                for (UserApplyAd nad : useradlist) {
                    if ((nad.getAd().getUserId().equals(me.getUserId()))) {
                        mylist.add(nad);
                    }
                }
           // }
        }        
        
        
        
    /*    AdDAOImpl addao = new AdDAOImpl();       
        Ad ad = addao.find(adid);
        
        User me = (User) request.getSession(false).getAttribute("me");

        UserApplyAdDAOImpl uadao = new UserApplyAdDAOImpl();
        
        List<UserApplyAd> userapplyadlist = uadao.list();
        List<UserApplyAd> myuseradlist = new ArrayList<>();


        if (!(userapplyadlist == null)) {
                //out.println("<p>- " + u.getFirstname()+ " " + u.getSurname()+ " " + u.getPassword() + " </p>");
                for (Ad ad : adlist) {
                    if ((ad.getUserId().getUserId().equals(me.getUserId()))) {
                        myuseradlist.add(ad);
                    }
                }
        }*/
       
        
        request.getSession(false).setAttribute("myuseradlist", mylist);
        request.setAttribute("myuseradlist", mylist);         
        
        
        
        
                
        //request.setAttribute("adid", ad);     

        
        String nextJSP = "/WEB-INF/complete/examinedetails1.jsp";
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