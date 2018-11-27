package servlets.navigation;

import dao.ArticleDAOImpl;
import dao.CommentDAOImpl;
import dao.ReactionDAOImpl;
import dao.UserDAOImpl;
import dao.UserIsConnectedToUserDAOImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Article;
import model.Comment;
import model.Reaction;
import model.User;
import model.UserIsConnectedToUser;

/**
 *
 * @author alex
 */
@WebServlet(name = "NearestNeighbourArticlesServlet", urlPatterns = {"/nearestneighbourarticles"})
public class NearestNeighbourArticlesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final int k = 3;

        User me = (User) request.getSession(false).getAttribute("me");
        UserDAOImpl udao = new UserDAOImpl();
      
        List<Article> articleList;     

        List<UserIsConnectedToUser> networkList;
        List<UserIsConnectedToUser> networkList1;


        UserIsConnectedToUserDAOImpl dao2 = new UserIsConnectedToUserDAOImpl();

        networkList = dao2.find(me.getUserId());
        networkList1 = dao2.find2(me.getUserId());

        ArticleDAOImpl adao3 = new ArticleDAOImpl();
        articleList = adao3.list();

        List<Article> allarticles = new ArrayList<>();
        List<Article> notconnectedarticles=adao3.list();        

        Integer connectedId;

        //Ta dika tou arthra
        for (Article article : articleList) {
            if ((article.getAuthorId().getUserId().equals(me.getUserId()))) {
                allarticles.add(article);
            }
        }

        //Ta syndedemena arthra
        if (!(networkList == null)) {
            for (UserIsConnectedToUser nlist : networkList) {

                connectedId = nlist.getUser1().getUserId();
                //out.println("<p>- " + u.getFirstname()+ " " + u.getSurname()+ " " + u.getPassword() + " </p>");

                for (Article article : articleList) {
                    if ((article.getAuthorId().getUserId().equals(connectedId))) {
                        allarticles.add(article);
                    } else {
                        if ((article.getAuthorId().getUserId().equals(me.getUserId()))) {
                            //conarticlelist.add(article);
                        }
                    }
                }
            }
        }
        if (!(networkList1 == null)) {
            for (UserIsConnectedToUser nlist1 : networkList1) {

                connectedId = nlist1.getUser().getUserId();

                for (Article article : articleList) {
                    if (article.getAuthorId().getUserId().equals(connectedId)) {
                        allarticles.add(article);
                    } else {
                        if ((article.getAuthorId().getUserId().equals(me.getUserId()))) {
                            //conarticlelist.add(article);
                        }
                    }
                }
            }
        }

        for (Article article : articleList) {
            if (!allarticles.contains(article)) {
                for (Reaction r : me.getReactionList()) {
                    if (r.getArticle().getArticleId().equals(article.getArticleId())) {
                        allarticles.add(article);
                    }
                }
            }
        }
        //Ta arthra twn epaggelmatiwn pou den anhkoun sto diktyo tou
        notconnectedarticles.removeAll(allarticles);
        
        
        //Ta arthra tou diktyou twn syndedmenwn xrhstwn
        
        //κ
        if (notconnectedarticles.size() > 0) {
            // kNN
            // ----------------------- find all reactions
            ReactionDAOImpl rdao = new ReactionDAOImpl();
            CommentDAOImpl cdao = new CommentDAOImpl();

            List<Reaction> all_reactions = rdao.list();
            List<Comment> all_comments = cdao.list();

            List<Integer> all_reaction_ids = all_reactions.stream().map((Reaction t) -> t.getReaction()).collect(Collectors.toList());
            List<Integer> all_comments_ids = all_comments.stream().map((Comment t) -> t.getCommentId()).collect(Collectors.toList());

            Integer user_pk = me.getUserId();

            double[] uv = udao.buildVector(user_pk, all_reaction_ids, all_comments_ids);

            List<Article> recommendedArray = new ArrayList<>();
            List<Double> distanceArray = new ArrayList<>();

            for (Article ad : notconnectedarticles) {
                Integer ad_pk = ad.getArticleId();
                double[] av = adao3.buildVector(ad_pk, all_reaction_ids, all_comments_ids);

                double distance = distance(av, uv);

                if (recommendedArray.size() < k) {
                    recommendedArray.add(ad);
                    distanceArray.add(distance);
                } else {
                    double max = 0;
                    int maxpos = -1;
                    for (int i = 0; i < recommendedArray.size(); i++) {
                        if (distanceArray.get(i) > max) {
                            max = distanceArray.get(i);
                            maxpos = i;
                        }
                    }

                    if (maxpos >= 0) {
                        if (distance < max) {
                            recommendedArray.set(maxpos, ad);
                            distanceArray.set(maxpos, distance);
                        }
                    }
                }
            }

            notconnectedarticles.clear();
            notconnectedarticles.addAll(recommendedArray);
        } 
        
        request.getSession(false).setAttribute("conarticlelist", notconnectedarticles);

        request.setAttribute("conarticlelist", notconnectedarticles);        
        
        String nextJSP = "/WEB-INF/complete/nearestneighbourarticles.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);

        dispatcher.forward(request, response);
        
        return;
        
      
        
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

    private double distance(double[] av, double[] uv) {
        double d = 0;
        int m = av.length;

        for (int i = 0; i < m; i++) {
            d = d + (Math.abs(av[i] - uv[i]));
        }
        return d;
    }

}
