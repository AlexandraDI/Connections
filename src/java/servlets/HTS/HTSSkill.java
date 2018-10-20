
package servlets.HTS;

import dao.definitions.JobDAO;
import dao.JobDAOImpl;

import dao.definitions.SkillDAO;
import dao.SkillDAOImpl;
import dao.JobHasSkillDAOImpl;
import dao.UserHasSkillDAOImpl;
import dao.definitions.JobHasSkillDAO;
import dao.definitions.UserHasSkillDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Job;
import model.Skill;

/**
 *
 * @author alex
 */
@WebServlet(name = "HTSSkill", urlPatterns = {"/skill"})
public class HTSSkill extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
            //-----------------------JOB------------------------
            //---------------------------------------------------
            

            

            JobHasSkillDAOImpl dao = new JobHasSkillDAOImpl();
            
            UserHasSkillDAOImpl dao2 = new UserHasSkillDAOImpl();
            
            try {
                dao2.create(1,1);
                out.println("<p>User has Skill created (correct)</p>");
            } catch (Exception ex) {
                out.println("<p>User has Skill not created (error)</p>");
            }            
            
            
            
            try {
                dao.create(1,1);
                out.println("<p>Skill created (correct)</p>");
            } catch (Exception ex) {
                out.println("<p>Skill not created (error)</p>");
            }     
            
            /*
            if( dao.remove(2,1)){
                out.println("<p>Job removed (correct)</p>");
            }else{
                out.println("<p>Job not removed (error)</p>");
            }            
            */
          

            
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
