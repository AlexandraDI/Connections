package servlets.HTS;

import dao.definitions.UserDAO;
import dao.UserDAOImpl;
import dao.definitions.AdministratorDAO;
import dao.AdministratorDAOImpl;
import dao.AdDAOImpl;
import dao.definitions.InterestDAO;
import dao.InterestDAOImpl;
import dao.UserIsConnectedToUserDAOImpl;
import dao.definitions.UserIsConnectedToUserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import model.Administrator;
import model.Interest;
import model.UserIsConnectedToUser;
import jpautils.EntityManagerHelper;
import javax.persistence.EntityTransaction;
import model.Ad;

/**
 *
 * @author alex
 */
@WebServlet(name = "HTSUserIsConnectedToUser", urlPatterns = {"/connected"})
public class HTSUserIsConnectedToUser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            // add prefix
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");

            //***************************************************
            //---------------------------------------------------
            //-----------------------USER------------------------
            //---------------------------------------------------
            UserIsConnectedToUserDAOImpl dao = new UserIsConnectedToUserDAOImpl();
            AdDAOImpl dao2 = new AdDAOImpl();

            int userId = 1;
            out.println("<h1>Test listall()");
            List<UserIsConnectedToUser> users = dao.find(userId);

            out.println("<p>Total users: " + users.size() + "</p>");
            
            out.println("<h1>Test lists####()");
            List<Ad> adlist = dao2.list();            
            int connecteduserId;
            List<Ad> conadlist = new ArrayList<>();
            
            for (UserIsConnectedToUser nlist1 : users) {

                connecteduserId = nlist1.getUser1().getUserId();
                //out.println("<p>The net is: " + nlist1.getUser1().getUserId() + " " + " </p>");
                for (Ad ad : adlist) {
                    //out.println("<p>for: " + ad.getUserId().getUserId() + " " + " </p>");
                    if (ad.getUserId().getUserId().equals(connecteduserId)) {
                        out.println("<p>The add is: " + ad.getUserId().getUserId() + " " + " </p>");
                        conadlist.add(ad);
                    }
                }
            }  
            out.println("<h1>Test lists####()");            

            //out.println("<p>- " + users.get(userId)+ " " + " </p>");
            for (int i = 0; i < users.size(); i++) {
                out.println("<p>-!- "+ users.get(i)/*.getUser1().getUserId()*/+" </p>");
            }
            
            

            for (UserIsConnectedToUser u : users) {

                out.println("<p>- " + u.getUser1().getUserId() + " " + " </p>");
            }

            out.println("<h1>Test listall2()");
            List<UserIsConnectedToUser> moreusers;
            moreusers = dao.find2(userId);

            out.println("<p>Total moreusers: " + moreusers.size() + "</p>");

            for (UserIsConnectedToUser u : moreusers) {

                out.println("<p>- " + u.getUser().getUserId() + " " + " </p>");
            }
            
            

            out.println("<h1>Test lists####()");
            
            for (UserIsConnectedToUser nlist1 : users) {

                connecteduserId = nlist1.getUser().getUserId();
                 
                for (Ad ad : adlist) {
                    if (ad.getUserId().equals(connecteduserId)) {
                        out.println("<p>The add is: " + ad.getUserId() + " " + " </p>");
                        conadlist.add(ad);
                    }
                }
            }  
            out.println("<h1>Test lists####()");

        }

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
