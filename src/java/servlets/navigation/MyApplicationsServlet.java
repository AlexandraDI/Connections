package servlets.navigation;

import dao.AdDAOImpl;
import dao.UserDAOImpl;
import dao.definitions.AdDAO;
import dao.definitions.UserDAO;
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
import model.User;
import model.Job;
import model.UserApplyAd;
import model.UserIsConnectedToUser;

/**
 *
 * @author alex
 */
@WebServlet(name = "MyApplicationsServlet", urlPatterns = {"/myapplications"})
public class MyApplicationsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        User me = (User) request.getSession(false).getAttribute("me");

        
        UserDAOImpl udao =new UserDAOImpl();
        List<Ad> my= new ArrayList<>();
        List<UserApplyAd> myapplications = udao.find(me.getUserId()).getUserApplyAdList();        

        if (!(myapplications == null)) {
            for (UserApplyAd list : myapplications) {
                        my.add(list.getAd());
            }
        }         
       
        
        request.getSession(false).setAttribute("myadlist", my);
        request.setAttribute("myadlist", my); 

        
        String nextJSP = "/WEB-INF/complete/myapplications.jsp";
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

    private UserDAOImpl UserDAOImpl() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}