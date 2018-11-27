package servlets.navigation;

import dao.SkillDAOImpl;
import dao.UserDAOImpl;
import dao.UserHasSkillDAOImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Skill;
import model.User;
import model.UserHasSkill;

/**
 *
 * @author alex
 */
@WebServlet(name = "ManageSkillsServlet", urlPatterns = {"/manageskills"})
public class ManageSkillsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, String[]> params = request.getParameterMap();

        UserDAOImpl udao = new UserDAOImpl();
        SkillDAOImpl dao = new SkillDAOImpl();
        
        
        User me = (User) request.getSession(false).getAttribute("me");

        try {
            if (!params.isEmpty()) {
                UserHasSkillDAOImpl uhs = new UserHasSkillDAOImpl();

                String sdo = params.get("do")[0];
                String skillId = params.get("skillId")[0];
                
                if (sdo.equals("add")) {
                    uhs.create(me.getUserId(), Integer.parseInt(skillId)); 
                } else if (sdo.equals("delete")) {
                    uhs.remove(me.getUserId(), Integer.parseInt(skillId));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        
        List<UserHasSkill> myskills= udao.find(me.getUserId()).getUserHasSkillList();
        List<Skill> my=new ArrayList<>();
        List<Skill> other_skills = dao.list();
        List<Skill> other=new ArrayList<>();
        Integer size=other_skills.size();
        Integer i=0;
        for(UserHasSkill skill: myskills){
            for(i=0; i<size; i++){
             if(skill.getSkill().getToolsAndTechnologyId().equals(other_skills.get(i).getToolsAndTechnologyId())){
              other.add(skill.getSkill());             
             }
             
            }
        }
        other_skills.removeAll(other);
               
        request.setAttribute("myskills", myskills);
        request.setAttribute("other_skills", other_skills);

        String nextJSP = "/WEB-INF/complete/manageskills.jsp";
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
