package servlets.navigation;

import dao.ArticleDAOImpl;
import dao.LanguageDAOImpl;
import dao.UserDAOImpl;
import dao.UserHasLanguageDAOImpl;
import dao.UserIsConnectedToUserDAOImpl;
import dao.definitions.ArticleDAO;
import dao.definitions.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Article;
import model.Language;
import model.UserIsConnectedToUser;
import model.User;

/**
 *
 * @author alex
 */
@WebServlet(name = "LanguageServlet", urlPatterns = {"/languages"})
public class LanguageServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, String[]> params = request.getParameterMap();

        UserDAOImpl udao = new UserDAOImpl();
        LanguageDAOImpl dao = new LanguageDAOImpl();
        
        
        User me = (User) request.getSession(false).getAttribute("me");

        try {
            if (!params.isEmpty()) {
                UserHasLanguageDAOImpl uhl = new UserHasLanguageDAOImpl();

                String sdo = params.get("do")[0];
                String languageId = params.get("languageId")[0];
                
                if (sdo.equals("add")) {
                    uhl.create(me.getUserId(), Integer.parseInt(languageId));
                } else if (sdo.equals("delete")) {
                    uhl.remove(me.getUserId(), Integer.parseInt(languageId));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        
        List<Language> mylanguages = udao.find(me.getUserId()).getLanguageList();
        List<Language> other_languages = dao.list();

        other_languages.removeAll(mylanguages);
               
        request.setAttribute("mylanguages", mylanguages);
        request.setAttribute("other_languages", other_languages);

        String nextJSP = "/WEB-INF/complete/language.jsp";
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
