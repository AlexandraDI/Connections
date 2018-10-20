package servlets.navigation;

import dao.ArticleDAOImpl;
import dao.UserDAOImpl;
import dao.definitions.ArticleDAO;
import dao.definitions.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Article;
import model.User;

/**
 *
 * @author alex
 */
@WebServlet(name = "ChangeEmailServlet", urlPatterns = {"/changeemail"})
public class ChangeEmailServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Map<String, String[]> params = request.getParameterMap();

        try {
            if (!params.isEmpty()) {
                User user = (User) request.getSession(false).getAttribute("me");

                String email = params.get("email")[0];
                String email1 = params.get("newemail1")[0];
                String email2 = params.get("newemail2")[0];

                if (email1.equals(email2)) {

                    //ArticleDAO dao = new ArticleDAOImpl();
                    UserDAO udao = new UserDAOImpl();

                    User owner = udao.find(user.getUserId());

                    if (owner.getEmail().equals(email)) {

                        user.setEmail(email1);
                        udao.update(owner.getUserId(), user);
                        request.setAttribute("result", "Email updated!");
                    } else {
                        request.setAttribute("result", "invalid email!");
                    }
                } else {
                    request.setAttribute("result", "invalid email verification");
                }
            }
        } catch (Exception ex) {
            for (Map.Entry<String, String[]> entry : params.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue()[0];

                request.setAttribute(key, value);
            }
            request.setAttribute("result", "error!");

        }

        String nextJSP = "/WEB-INF/complete/changeemail.jsp";
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
