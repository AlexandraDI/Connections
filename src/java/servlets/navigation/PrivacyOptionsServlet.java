package servlets.navigation;

import dao.UserHasSettingDAOImpl;
import dao.UserDAOImpl;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import model.UserHasSetting;

/**
 *
 * @author alex
 */
@WebServlet(name = "PrivacyOptionsServlet", urlPatterns = {"/privacyoptions"})
public class PrivacyOptionsServlet extends HttpServlet {

    private void updateSetting(UserHasSettingDAOImpl sdao, Integer userid, List<UserHasSetting> userSettings, int settingid, String value) {
        boolean found= false;
        
        for (UserHasSetting s : userSettings) {
            if (s.getUserHasSettingPK().getSettingId() == settingid) {
                s.setValue(value);
                
                sdao.update(s);
                return;
            }
        }
        
        sdao.create(userid, settingid,value);    
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Map<String, String[]> params = request.getParameterMap();
        UserHasSettingDAOImpl sdao= new UserHasSettingDAOImpl(); 
                User user = (User) request.getSession(false).getAttribute("me");
                UserDAOImpl udao= new UserDAOImpl();
                UserHasSetting uhs= new UserHasSetting();
                
                User me = udao.find(user.getUserId());
        
                me.getUserHasSettingList();
        

        try {
            if (!params.isEmpty()) {



                String basic = params.get("basicsettingId")[0];
                String rest = params.get("restsettingId")[0];
                String language = params.get("languagesettingId")[0];
                String experience = params.get("experiencesettingId")[0];
                String skill = params.get("skillsettingId")[0];
                String education = params.get("educationsettingId")[0];               

                List<UserHasSetting> userSettings = sdao.findUserSettings(user.getUserId());
                
                
                updateSetting(sdao, user.getUserId(), userSettings, 1, basic);
                updateSetting(sdao, user.getUserId(), userSettings, 2, rest);
                updateSetting(sdao, user.getUserId(), userSettings, 3, language);
                updateSetting(sdao, user.getUserId(), userSettings, 4, experience);
                updateSetting(sdao, user.getUserId(), userSettings, 5, skill);
                updateSetting(sdao, user.getUserId(), userSettings, 6, education);
                
                request.setAttribute("result", "Privacy updated!");

            }
        } catch (Exception ex) {
            for (Map.Entry<String, String[]> entry : params.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue()[0];

                request.setAttribute(key, value);
            }
            request.setAttribute("result", "error!");

        }
        
        request.setAttribute("usersetting", me);
        request.setAttribute("set", me.getUserHasSettingList());

        String nextJSP = "/WEB-INF/complete/privacyoptions.jsp";
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
