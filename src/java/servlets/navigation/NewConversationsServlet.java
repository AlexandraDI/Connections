/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.navigation;

import dao.ConversationDAOImpl;
import dao.MessageDAOImpl;
import dao.UserDAOImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Conversation;
import model.Message;
import model.User;

/**
 *
 * @author alex
 */
@WebServlet(name = "NewConversationsServlet", urlPatterns = {"/newconversations"})
public class NewConversationsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User me = (User) request.getSession(false).getAttribute("me");

        Map<String, String[]> params = request.getParameterMap();

        List<Conversation> List;
        List<Conversation> List1;
        List<Message> last = new ArrayList<>();
        List<Conversation> bestlist = new ArrayList<>();
        Integer conversationId, conversation1Id, conversation2Id;
        Integer size, size1;
        Date lastconversation, last1, last2;

        Integer userdetail = me.getUserId();
        UserDAOImpl udao = new UserDAOImpl();

        ConversationDAOImpl dao2 = new ConversationDAOImpl();

        try {
            if (!params.isEmpty() && params.get("do") != null) {

                String sdo = params.get("do")[0];
                ConversationDAOImpl cdao = new ConversationDAOImpl();

                if (sdo.equals("details")) {
                    Integer conversationid = Integer.parseInt(request.getParameter("id").toString());

                    List = cdao.find(userdetail);
                    List1 = cdao.find2(userdetail);

                    ConversationDAOImpl dao = new ConversationDAOImpl();
                    Conversation conversation = dao.findConversation(conversationid);
                    conversation.getMessageList();
                    
                    request.setAttribute("conversation", conversation);
                    request.setAttribute("conversationId", conversationid);
                    request.setAttribute("conversationlist", List);
                    request.setAttribute("conversationlist1", List1);

                    String nextJSP = "/WEB-INF/complete/newconversations.jsp";

                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
                    dispatcher.forward(request, response);

                    return;
                } else if (sdo.equals("startconversation")) {
                    Integer id = Integer.parseInt(request.getParameter("userid").toString());

                    ConversationDAOImpl dao = new ConversationDAOImpl();
                    Integer conversationid;

                    java.sql.Date date = new java.sql.Date(System.currentTimeMillis());

                    Conversation conversation = dao.startConversation(me.getUserId(), id, date, sdo);

                    List = cdao.find(userdetail);
                    List1 = cdao.find2(userdetail);

                    request.setAttribute("conversation", conversation);
                    request.setAttribute("conversationId", conversation.getConversationId());
                    request.setAttribute("conversationlist", List);
                    request.setAttribute("conversationlist1", List1);

                    String nextJSP = "/WEB-INF/complete/newconversations.jsp";

                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
                    dispatcher.forward(request, response);

                    return;
                } else if (sdo.equals("message")) {
                    Integer conversationid = Integer.parseInt(request.getParameter("conversationid").toString());
                    String contentOfMessage = params.get("contentOfMessage")[0];

                    ConversationDAOImpl dao = new ConversationDAOImpl();
                    MessageDAOImpl mdao = new MessageDAOImpl();
                    Message message = new Message();

                    java.sql.Date date = new java.sql.Date(System.currentTimeMillis());

                    Conversation conversation = dao.findConversation(conversationid);
                    conversation.setDatetimeUpdated(date);

                    message.setContent(contentOfMessage);
                    message.setDatetimeCreated(date);
                    message.setSenderId(me);
                    message.setConversationId(conversation);
                    message.setStatus(1);

                    dao.update(conversationid, conversation);
                    mdao.create(message);

                    List = cdao.find(userdetail);
                    List1 = cdao.find2(userdetail);

                    request.setAttribute("conversation", conversation);
                    request.setAttribute("conversationId", conversation.getConversationId());
                    request.setAttribute("conversationlist", List);
                    request.setAttribute("conversationlist1", List1);

                    String nextJSP = "/WEB-INF/complete/newconversations.jsp";

                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
                    dispatcher.forward(request, response);

                    return;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        List = dao2.find(userdetail);
        List1 = dao2.find2(userdetail);


        size = List.size();
        size1 = List1.size();
        conversationId=0;

        if (size > 0 && size1==0) {
            lastconversation = List.get(0).getDatetimeUpdated();
            conversationId = List.get(0).getConversationId();
            for (Conversation conversation : List) {

                if (conversation.getDatetimeUpdated().after(lastconversation)) {
                    lastconversation = conversation.getDatetimeUpdated();
                    conversationId = conversation.getConversationId();
                }
            }
        }
        else if (size1 > 0 && size==0) {
            lastconversation = List1.get(0).getDatetimeUpdated();
            conversationId = List1.get(0).getConversationId();
            for (Conversation conversation : List1) {

                if (conversation.getDatetimeUpdated().after(lastconversation)) {
                    lastconversation = conversation.getDatetimeUpdated();
                    conversationId = conversation.getConversationId();
                }
            }
        }
        else if(size>0 && size1>0){
            lastconversation = List.get(0).getDatetimeUpdated();
            conversationId = List.get(0).getConversationId();
            for (Conversation conversation : List) {

                if (conversation.getDatetimeUpdated().after(lastconversation)) {
                    lastconversation = conversation.getDatetimeUpdated();
                    conversationId = conversation.getConversationId();
                }
            }
            for (Conversation conversation : List1) {

                if (conversation.getDatetimeUpdated().after(lastconversation)) {
                    lastconversation = conversation.getDatetimeUpdated();
                    conversationId = conversation.getConversationId();
                }
            }            
        }
            ConversationDAOImpl cdao = new ConversationDAOImpl();
            Conversation conversation = cdao.findConversation(conversationId);
            if(conversation!= null){
                conversation.getMessageList();
                request.setAttribute("conversation", conversation); 
            }

            
        request.setAttribute("conversationId", conversationId);
        request.setAttribute("conversationlist", List);
        request.setAttribute("conversationlist1", List1);

        String nextJSP = "/WEB-INF/complete/newconversations.jsp";

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
