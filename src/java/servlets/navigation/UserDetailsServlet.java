package servlets.navigation;

import dao.ConversationDAOImpl;
import dao.UserConnectionRequestUserDAOImpl;
import dao.UserDAOImpl;
import dao.UserIsConnectedToUserDAOImpl;
import dao.definitions.UserConnectionRequestUserDAO;
import dao.definitions.UserIsConnectedToUserDAO;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Conversation;
import model.ProfessionalExperience;
import model.User;
import model.UserConnectionRequestUser;
import model.UserHasSetting;
import model.UserIsConnectedToUser;

/**
 *
 * @author alex
 */
@WebServlet(name = "UserDetailsServlet", urlPatterns = {"/userdetails"})
public class UserDetailsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Map<String, String[]> params = request.getParameterMap();

        User me = (User) request.getSession(false).getAttribute("me");

        try {
            if (!params.isEmpty() && params.get("do") != null) {

                String sdo = params.get("do")[0];

                if (sdo.equals("sendfriendrequest")) {
                    Integer id = Integer.parseInt(request.getParameter("id").toString());

                    UserConnectionRequestUserDAO dao = new UserConnectionRequestUserDAOImpl();
                    dao.startRequest(me.getUserId(), id);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Integer myid = me.getUserId();

        Integer id = Integer.parseInt(request.getParameter("id").toString());

        UserDAOImpl udao = new UserDAOImpl();

        User user;

        user = udao.find(id); // update from db

        user.getLanguageList();

        for (ProfessionalExperience p : user.getProfessionalExperienceList()) {
            p.getJobId();
        }
        user.getEducationList();
        user.getUserHasSkillList();
       
        request.setAttribute("user", user);

        {
            UserIsConnectedToUserDAO dao = new UserIsConnectedToUserDAOImpl();

            List<UserIsConnectedToUser> find = dao.find(id);
            List<UserIsConnectedToUser> find2 = dao.find2(id);

            find.addAll(find2);

            boolean friend = false;

            for (UserIsConnectedToUser e : find) {
                if (e.getUser().getUserId() == myid && e.getUser1().getUserId() == id) {
                    friend = true;
                    break;
                }

                if (e.getUser().getUserId() == id && e.getUser1().getUserId() == myid) {
                    friend = true;
                    break;
                }
            }

            request.setAttribute("friend", friend);
        }

        {
            UserConnectionRequestUserDAO dao = new UserConnectionRequestUserDAOImpl();

            List<UserConnectionRequestUser> find = dao.find(myid);
            List<UserConnectionRequestUser> find2 = dao.find2(myid);
            find.addAll(find2);

            boolean requestpending = false;

            for (UserConnectionRequestUser e : find) {
                if (e.getUser().getUserId() == myid && e.getUser1().getUserId() == id) {
                    requestpending = true;
                    break;
                }

                if (e.getUser().getUserId() == id && e.getUser1().getUserId() == myid) {
                    requestpending = true;
                    break;
                }
            }

            request.setAttribute("requestpending", requestpending);
        }

        {
            List<UserHasSetting> userHasSettingList = user.getUserHasSettingList();

            boolean languages_private = false;//3
            boolean experience_private = false;//4
            boolean skills_private = false;//5
            boolean education_private = false;//6

            for (UserHasSetting s : userHasSettingList) {
                switch (s.getSetting().getSettingId()) {
                    case 3:
                        languages_private = (s.getValue().equals("FRIENDS"));
                        break;
                    case 4:
                        experience_private = (s.getValue().equals("FRIENDS"));
                        break;
                    case 5:
                        skills_private = (s.getValue().equals("FRIENDS"));
                        break;
                    case 6:
                        education_private = (s.getValue().equals("FRIENDS"));
                        break;
                }
            }

            request.setAttribute("languages_private", languages_private);
            request.setAttribute("experience_private", experience_private);
            request.setAttribute("skills_private", skills_private);
            request.setAttribute("education_private", education_private);
        }
        {

            ConversationDAOImpl cdao = new ConversationDAOImpl();
            List<Conversation> clist, clist1;
            clist = cdao.find(myid);
            clist1 = cdao.find2(myid);            
            boolean conversation = false;

            for (Conversation conv : clist) {
                if ((conv.getUser1Id().getUserId() == id)||(conv.getUser2Id().getUserId() == id))  {
                    conversation = true;
                }
            }
                for (Conversation conv : clist1) {
                    if ((conv.getUser1Id().getUserId() == id) ||(conv.getUser2Id().getUserId() == id)) {
                        conversation = true;
                    }

                }

            request.setAttribute("conversation", conversation);
        }

        String nextJSP = "/WEB-INF/complete/userdetails.jsp";
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
