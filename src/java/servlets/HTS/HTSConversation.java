package servlets.HTS;

import dao.ConversationDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Conversation;
import model.Article;

/**
 *
 * @author alex
 */
@WebServlet(name = "HTSConversation", urlPatterns = {"/conversation"})
public class HTSConversation extends HttpServlet {

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
            //-----------------------USER------------------------
            //---------------------------------------------------

        List<Conversation> List;
        List<Conversation> List1;

        Integer userdetail= 1;

        ConversationDAOImpl dao2 = new ConversationDAOImpl();

        List = dao2.find(userdetail);
        List1 = dao2.find2(userdetail);

        List<Article> conarticlelist = new ArrayList<>();

        Integer connecteduserId;
        
        
        for (Conversation nlist1 : List) {
                    out.println("<p>The net is: " + nlist1.getUser2Id().getUserId() + " " + " </p>");
        }
        for (Conversation nlist1 : List1) {
                        out.println("<p>The net2 is: " + nlist1.getUser1Id().getUserId() + " " + " </p>");
        }   
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        
        dao2.startConversation(userdetail, 10, date ,"header7");


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
