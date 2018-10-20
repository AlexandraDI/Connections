package servlets.navigation;

import dao.UserConnectionRequestUserDAOImpl;
import dao.UserIsConnectedToUserDAOImpl;
import dao.UserDAOImpl;
import dao.AdDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Article;
import model.Reaction;
import model.User;
import model.UserConnectionRequestUser;

/**
 *
 * @author alex
 */
@WebServlet(name = "ManageRequestsServlet", urlPatterns = {"/managerequests"})
public class ManageRequestsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, String[]> params = request.getParameterMap();

        User me = (User) request.getSession(false).getAttribute("me");

        UserDAOImpl udao = new UserDAOImpl();

        List<User> users = new ArrayList<>();
        List<User> not = new ArrayList<>();

        try {
            if (!params.isEmpty()) {

                java.sql.Date date = new java.sql.Date(System.currentTimeMillis());

                String sdo = params.get("do")[0];
                AdDAOImpl adao = new AdDAOImpl();

                if (sdo.equals("accept")) {
                    UserIsConnectedToUserDAOImpl uudao = new UserIsConnectedToUserDAOImpl();
                    UserConnectionRequestUserDAOImpl rdao = new UserConnectionRequestUserDAOImpl();

                    String userId = params.get("userId")[0];
                    uudao.create(Integer.parseInt(userId), me.getUserId(), date);
                    
                    rdao.stopRequest(Integer.parseInt(userId), me.getUserId());
                } else if (sdo.equals("deny")) {
                    UserConnectionRequestUserDAOImpl rdao = new UserConnectionRequestUserDAOImpl();
                    String userId = params.get("userId")[0];

                    rdao.stopRequest(Integer.parseInt(userId), me.getUserId());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        List<UserConnectionRequestUser> networkList;

        UserConnectionRequestUserDAOImpl dao3 = new UserConnectionRequestUserDAOImpl();

        networkList = dao3.find2(me.getUserId());

        request.setAttribute("requests", networkList);

        String nextJSP = "/WEB-INF/complete/managerequests.jsp";
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
