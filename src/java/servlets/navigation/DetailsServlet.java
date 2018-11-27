/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.navigation;

import dao.ArticleDAOImpl;
import dao.ReactionDAOImpl;
import dao.UserDAOImpl;
import dao.CommentDAOImpl;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Article;
import model.Comment;
import model.Reaction;
import model.ReactionPK;
import model.User;

/**
 *
 * @author alex
 */
@WebServlet(name = "Detailservlet", urlPatterns = {"/details"})
public class DetailsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, String[]> params = request.getParameterMap();

        UserDAOImpl udao = new UserDAOImpl();

        User me = (User) request.getSession(false).getAttribute("me");

        Integer articleid = Integer.parseInt(request.getParameter("articleid").toString());

        ArticleDAOImpl dao = new ArticleDAOImpl();

        Article article = dao.find(articleid);

        try {
            if (!params.isEmpty()) {

                String sdo = params.get("do")[0];

                if (sdo.equals("add")) {
                    CommentDAOImpl com = new CommentDAOImpl();
                    Comment entity = new Comment();
                    java.sql.Date date = new java.sql.Date(System.currentTimeMillis());

                    String contentOfComment = params.get("contentOfComment")[0];
                    entity.setArticleId(article);
                    entity.setContent(contentOfComment);                    
                    entity.setDatetimeCreated(date);
                    entity.setUserId(me);
                    com.create(entity);
                } else if (sdo.equals("delete")) {
                    Integer commentId = Integer.parseInt(request.getParameter("commentid"));
                    CommentDAOImpl com = new CommentDAOImpl();
                    Comment entity = com.find(commentId);
                    if (entity != null) {
                        com.remove(commentId);
                    }                    
                } else if (sdo.equals("rate")) {
                    Integer articleId = Integer.parseInt(request.getParameter("articleid"));
                    Integer newreaction = Integer.parseInt(request.getParameter("reaction"));

                    Reaction entity = new Reaction();

                    ReactionPK pk = new ReactionPK();

                    Article a = dao.find(articleId);

                    pk.setArticleId(articleId);
                    pk.setUserId(me.getUserId());

                    entity.setReactionPK(pk);
                    entity.setReaction(newreaction);
                    entity.setUser(me);
                    entity.setArticle(a);

                    ReactionDAOImpl rdao = new ReactionDAOImpl();

                    rdao.create(entity);
                } else if (sdo.equals("deleterate")) {
                    Integer articleId = Integer.parseInt(request.getParameter("articleid"));
                    
                    ReactionDAOImpl rdao = new ReactionDAOImpl();
                    
                    
                    Reaction entity = rdao.find(me.getUserId(), articleId);
                    if (entity != null) {
                        rdao.remove(entity);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        me = udao.find(me.getUserId());

        request.getSession().setAttribute("me", me);

        boolean reacted = false;
        int reaction = -1;
        for (Reaction r : me.getReactionList()) {
            if (r.getArticle().getArticleId().equals(articleid)) {
                reacted = true;
                reaction = r.getReaction();
                break;
            }
        }

        List<Comment> comments = dao.find(articleid).getCommentList();

        request.setAttribute("articledetail", article);
        request.setAttribute("comments", comments);
        request.setAttribute("reaction", reaction);
        request.setAttribute("liked", reacted);

        String nextJSP = "/WEB-INF/complete/details.jsp";
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
