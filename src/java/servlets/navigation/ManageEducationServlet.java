package servlets.navigation;

import dao.DepartmentDAOImpl;
import dao.EducationDAOImpl;
import dao.JobDAOImpl;
import dao.ProfessionalExperienceDAOImpl;
import dao.UserDAOImpl;
import dao.UserHasLanguageDAOImpl;
import dao.UserIsConnectedToUserDAOImpl;
import dao.definitions.ArticleDAO;
import dao.definitions.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Comparator;
import java.util.Date;
import java.text.SimpleDateFormat;  
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Article;
import model.Department;
import model.Education;
import model.ProfessionalExperience;
import model.UserIsConnectedToUser;
import model.User;
import model.Job;

/**
 *
 * @author alex
 */
@WebServlet(name = "ManageEducationServlet", urlPatterns = {"/manageeducation"})
public class ManageEducationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, String[]> params = request.getParameterMap();

        UserDAOImpl udao = new UserDAOImpl();
        EducationDAOImpl dao = new EducationDAOImpl();

        DepartmentDAOImpl ddao = new DepartmentDAOImpl();

        User me = (User) request.getSession(false).getAttribute("me");

        try {
            if (!params.isEmpty()) {
                UserHasLanguageDAOImpl uhl = new UserHasLanguageDAOImpl();
                EducationDAOImpl ed = new EducationDAOImpl();
                Education education = new Education();

                String sdo = params.get("do")[0];

                if (sdo.equals("add")) {
                    Date date1,date2;
                    String departmentId = params.get("departmentId")[0];
                    String degree = params.get("degree")[0];
                    //String entryyear = params.get("entryyear")[0];
                    //Job job= new Job();
                    Department department= ddao.find(Integer.parseInt(departmentId));
                    //job.setJobId(Integer.parseInt(jobId));
                    //job.setName(sdo);
                    
                    education.setUserId(me);
                    education.setDepartmentId(department);
                    education.setDegree(degree);
                    //java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
                    //LocalDate localDate = date.toLocalDate();
                    //date.getYear();
                    //DateFormat dateFormat = new SimpleDateFormat("yyyy"); 
                    //date1 = dateFormat.parse(entryyear);
                    //education.setEntryYear(date);
                    ed.create(education);
                    

                } else if (sdo.equals("delete")) {
                    String educationId = params.get("educationId")[0];
                    ed.remove(Integer.parseInt(educationId));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        me = udao.find(me.getUserId());
        List<Education> myeducation = me.getEducationList();

        List<Department> departments = ddao.list();

        for (Education p : me.getEducationList()) {
            p.getDepartmentId();
            //Education
        }
        //other_experiences.removeAll(myexperiences);

        request.setAttribute("myeducation", myeducation);
        //request.setAttribute("other_experiences", other_experiences);
        request.setAttribute("departments", departments);

        String nextJSP = "/WEB-INF/complete/manageeducation.jsp";
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
