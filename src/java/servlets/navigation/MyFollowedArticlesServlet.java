
package servlets.navigation;

import dao.ArticleDAOImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
@WebServlet(name = "MyFollowedArticlesServlet", urlPatterns = {"/myfollowedarticles"})
public class MyFollowedArticlesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        

        User me = (User) request.getSession(false).getAttribute("me");
        List<Article> articleList;

        ArticleDAOImpl dao3 = new ArticleDAOImpl();
        articleList = dao3.list();

        List<Article> myarticles = new ArrayList<>();

        //Ta dika tou arthra
        for (Article article : articleList) {
            if ((article.getAuthorId().getUserId().equals(me.getUserId()))) {
                if (!article.getCommentList().isEmpty()) {
                    myarticles.add(article);
                }
            }
        }                
        
        myarticles.sort(new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                return o1.getDatetimeCreated().compareTo(o2.getDatetimeCreated());
            }
        });
        

        request.setAttribute("conarticlelist", myarticles);

        
        String nextJSP = "/WEB-INF/complete/myfollowedarticles.jsp";
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
