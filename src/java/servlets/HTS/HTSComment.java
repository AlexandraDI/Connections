package servlets.HTS;

import dao.definitions.UserDAO;
import dao.UserDAOImpl;
import dao.definitions.AdministratorDAO;
import dao.UserDAOImpl;
import dao.AdDAOImpl;
import dao.ArticleDAOImpl;
import dao.CommentDAOImpl;
import dao.definitions.InterestDAO;
import dao.InterestDAOImpl;
import dao.ConversationDAOImpl;
import dao.UserIsConnectedToUserDAOImpl;
import dao.definitions.ConversationDAO;
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
import model.Conversation;
import jpautils.EntityManagerHelper;
import javax.persistence.EntityTransaction;
import model.Ad;
import model.Article;
import model.Comment;

/**
 *
 * @author alex
 */
@WebServlet(name = "HTSComment", urlPatterns = {"/comment"})
public class HTSComment extends HttpServlet {

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
            //-----------------------Comment------------------------
            //---------------------------------------------------


        Integer userdetail= 8;

        CommentDAOImpl dao2 = new CommentDAOImpl();
        Comment com= new Comment();
        ArticleDAOImpl ardao = new ArticleDAOImpl();
        UserDAOImpl udao = new UserDAOImpl();
        
        User u = new User();
        u = udao.find(userdetail);


        Integer connecteduserId;
        Integer articleId;
        articleId=2;
        Article article= ardao.find(articleId);
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        com.setArticleId(article);
        com.setContent("content of article");
        com.setDatetimeCreated(date);
        com.setUserId(u);


           try {
                dao2.create(com);
                out.println("<p>User NU created (correct)</p>");
            } catch (Exception ex) {
                out.println("<p>User NU not created (error)</p>");
            } 
            
            //dao2.remove(5);


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
