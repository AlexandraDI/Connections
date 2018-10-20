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
import javax.servlet.http.HttpSession;
import model.Article;
import model.User;
import parsers.UserAdapter;
import dao.ArticleDAOImpl;
import dao.UserIsConnectedToUserDAOImpl;
import dao.definitions.ArticleDAO;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.Ad;
import model.Reaction;
import model.UserIsConnectedToUser;

/**
 *
 * @author alex
 */
@WebServlet(name = "XronologioServlet", urlPatterns = {"/xronologio"})
public class XronologioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, String[]> params = request.getParameterMap();

        try {
            if (!params.isEmpty()) {
                User user = (User) request.getSession(false).getAttribute("me");

                String title = params.get("title")[0];
                String content = params.get("content")[0];

                ArticleDAO dao = new ArticleDAOImpl();
                UserDAO udao = new UserDAOImpl();

                User author = udao.find(user.getUserId());

                Article a = new Article();
                a.setTitle(title);
                a.setContent(content);
                a.setDatetimeCreated(new Date());
                a.setAuthorId(author);

                dao.create(a);

                request.setAttribute("result", "Article created!");

            }
        } catch (Exception ex) {
            for (Map.Entry<String, String[]> entry : params.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue()[0];

                request.setAttribute(key, value);
            }
            request.setAttribute("result", "error!");

        }

        User me = (User) request.getSession(false).getAttribute("me");
        //////////////HttpSession session = request.getSession();        
        List<Article> articleList;
        ////////articleList = (List<Article>) request.getSession(false).getAttribute("articleList");       

        List<UserIsConnectedToUser> networkList;
        List<UserIsConnectedToUser> networkList1;
        /*networkList = (List<UserIsConnectedToUser>) request.getSession(false).getAttribute("networkList");
        networkList1 = (List<UserIsConnectedToUser>) request.getSession(false).getAttribute("networkList1");*/

        User userdetail;

        UserIsConnectedToUserDAOImpl dao2 = new UserIsConnectedToUserDAOImpl();

        networkList = dao2.find(me.getUserId());
        networkList1 = dao2.find2(me.getUserId());

        ArticleDAOImpl dao3 = new ArticleDAOImpl();
        articleList = dao3.list();

        List<Article> allarticles = new ArrayList<>();

        Integer connecteduserId;

        //Ta dika tou arthra
        for (Article article : articleList) {
            if ((article.getAuthorId().getUserId().equals(me.getUserId()))) {
                allarticles.add(article);
            }
        }

        //Ta syndedemena arthra
        if (!(networkList == null)) {
            for (UserIsConnectedToUser nlist : networkList) {

                connecteduserId = nlist.getUser1().getUserId();
                //out.println("<p>- " + u.getFirstname()+ " " + u.getSurname()+ " " + u.getPassword() + " </p>");

                for (Article article : articleList) {
                    if ((article.getAuthorId().getUserId().equals(connecteduserId))) {
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

                connecteduserId = nlist1.getUser().getUserId();

                for (Article article : articleList) {
                    if (article.getAuthorId().getUserId().equals(connecteduserId)) {
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
        
        allarticles.sort(new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                return o1.getDatetimeCreated().compareTo(o2.getDatetimeCreated());
            }
        });
        
        //Na ftia3w mia ta3inomhmenh lista
        request.getSession(false).setAttribute("conarticlelist", allarticles);
        request.getSession(false).setAttribute("networkList", networkList);
        request.getSession(false).setAttribute("networkList1", networkList1);

//        request.setAttribute("articleList", articleList);
        request.setAttribute("conarticlelist", allarticles);

        request.setAttribute("networkList", networkList);
        request.setAttribute("networkList1", networkList1);

        String nextJSP = "/WEB-INF/complete/xronologio.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);

        ///getServletContext().getRequestDispatcher("/WEB-INF/complete/xronologio.jsp").forward(request, response);
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
