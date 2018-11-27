package servlets.navigation;

import dao.AdDAOImpl;
import dao.UserApplyAdDAOImpl;
import dao.UserDAOImpl;
import java.io.IOException;
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

/**
 *
 * @author alex
 */
@WebServlet(name = "ExamineDetailsServlet", urlPatterns = {"/examinedetails"})
public class ExamineDetailsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, String[]> params = request.getParameterMap();

        Integer adid = Integer.parseInt(request.getParameter("id").toString());

        User me = (User) request.getSession(false).getAttribute("me");

        AdDAOImpl addao = new AdDAOImpl();
        UserDAOImpl udao = new UserDAOImpl();
        UserApplyAdDAOImpl uaa = new UserApplyAdDAOImpl();

        try {
            if (!params.isEmpty()) {

                java.sql.Date date = new java.sql.Date(System.currentTimeMillis());

                String sdo = params.get("do")[0];
                AdDAOImpl adao = new AdDAOImpl();

                if (sdo.equals("accept")) {
                    Ad ad = new Ad();

                    String userId = params.get("userId")[0];
                    String adId = params.get("adId")[0];

                    //kanw remove to application
                    uaa.remove(Integer.parseInt(userId), Integer.parseInt(adId));

                    //na kanw remove to ad
                    adao.remove(Integer.parseInt(adId));

                    String nextJSP = "/WEB-INF/complete/examinedetails.jsp";
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
                    dispatcher.forward(request, response);
                    return;

                } else if (sdo.equals("deny")) {
                    String userId = params.get("userId")[0];
                    String adId = params.get("adId")[0];
                    uaa.remove(Integer.parseInt(userId), Integer.parseInt(adId));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //H aggelia mou
        Ad myad = addao.find(adid);
        //Oles oi aithseis
        List<UserApplyAd> applications = myad.getUserApplyAdList();

        request.setAttribute("myuseradlist", applications);
   
        String nextJSP = "/WEB-INF/complete/examinedetails.jsp";
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
