package servlets.navigation;

import dao.JobDAOImpl;
import dao.ProfessionalExperienceDAOImpl;
import dao.UserDAOImpl;
import dao.UserHasLanguageDAOImpl;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;  
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProfessionalExperience;
import model.User;
import model.Job;

/**
 *
 * @author alex
 */
@WebServlet(name = "AddWorkExperienceServlet", urlPatterns = {"/addworkexperience"})
public class AddWorkExperienceServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, String[]> params = request.getParameterMap();

        UserDAOImpl udao = new UserDAOImpl();
        ProfessionalExperienceDAOImpl dao = new ProfessionalExperienceDAOImpl();

        JobDAOImpl jdao = new JobDAOImpl();

        User me = (User) request.getSession(false).getAttribute("me");

        try {
            if (!params.isEmpty()) {
                UserHasLanguageDAOImpl uhl = new UserHasLanguageDAOImpl();
                ProfessionalExperienceDAOImpl pe = new ProfessionalExperienceDAOImpl();
                ProfessionalExperience experience = new ProfessionalExperience();

                String sdo = params.get("do")[0];

                if (sdo.equals("add")) {
                    Date date1,date2;
                    String jobId = params.get("jobId")[0];
                    String dateStarted = params.get("dateStarted")[0];
                    String dateEnded = params.get("dateEnded")[0];
                    //Job job= new Job();
                    Job job= jdao.find(Integer.parseInt(jobId));
                    //job.setJobId(Integer.parseInt(jobId));
                    //job.setName(sdo);
                    
                    experience.setUserId(me);
                    experience.setJobId(job);
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
                    date1 = dateFormat.parse(dateStarted);
                    experience.setDateStarted(date1);
                    if(dateEnded.equals("yyyy-MM-dd")){
                       pe.create(experience);
                    }
                    else{
                          date2 = dateFormat.parse(dateEnded);
                          experience.setDateEnded(date2); 
                          pe.create(experience);
                    }
                    

                } else if (sdo.equals("delete")) {
                    String experienceId = params.get("experienceId")[0];
                    pe.remove(Integer.parseInt(experienceId));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        me = udao.find(me.getUserId());
        List<ProfessionalExperience> myexperiences = me.getProfessionalExperienceList();
        List<Job> jobs = jdao.list();

        for (ProfessionalExperience p : me.getProfessionalExperienceList()) {
            p.getJobId();
        }

        request.setAttribute("myexperiences", myexperiences);
        request.setAttribute("jobs", jobs);

        String nextJSP = "/WEB-INF/complete/addworkexperience.jsp";
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
