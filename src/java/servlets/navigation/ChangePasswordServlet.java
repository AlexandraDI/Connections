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
@WebServlet(name = "ChangePasswordServlet", urlPatterns = {"/changepassword"})
public class ChangePasswordServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Map<String, String[]> params = request.getParameterMap();

        try {
            if (!params.isEmpty()) {
                User user = (User) request.getSession(false).getAttribute("me");

                String password = params.get("password")[0];
                String password1 = params.get("newpassword1")[0];
                String password2 = params.get("newpassword2")[0];

                if (password1.equals(password2)) {

                    //ArticleDAO dao = new ArticleDAOImpl();
                    UserDAO udao = new UserDAOImpl();

                    User owner = udao.find(user.getUserId());

                    if (owner.getPassword().equals(password)) {

                        user.setPassword(password1);
                        udao.update(owner.getUserId(), user);
                        request.setAttribute("result", "password updated!");
                    } else {
                        request.setAttribute("result", "invalid password!");
                    }
                } else {
                    request.setAttribute("result", "invalid password verification");
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

        String nextJSP = "/WEB-INF/complete/changepassword.jsp";
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
