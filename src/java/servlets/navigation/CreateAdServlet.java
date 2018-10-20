package servlets.navigation;

import dao.AdDAOImpl;
import dao.JobDAOImpl;
import dao.UserDAOImpl;
import dao.definitions.AdDAO;
import dao.definitions.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Ad;
import model.User;
import model.Job;

/**
 *
 * @author alex
 */
@WebServlet(name = "CrateAdServlet", urlPatterns = {"/createad"})
public class CreateAdServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Map<String, String[]> params = request.getParameterMap();

        try {
            if (!params.isEmpty()) {
                User user = (User) request.getSession(false).getAttribute("me");

                String title = params.get("title")[0];
                String desc = params.get("desc")[0];  
                Integer jobId = Integer.parseInt(request.getParameter("jobId").toString());

                //ArticleDAO dao = new ArticleDAOImpl();
                AdDAO dao = new AdDAOImpl();
                UserDAO udao = new UserDAOImpl();
                Job job = new Job();               

                //User author = udao.find(user.getUserId());
                java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
                /////////////////////////////////
                job.setJobId(jobId);

                Ad ad = new Ad();
                ad.setDatetimeCreated(date);
                ad.setDescription(desc);
                ad.setJobId(job);
                ad.setUserId(user);
                ad.setTitle(title);                

                dao.create(ad);

                request.setAttribute("result", "Ad created!");

            }
        } catch (Exception ex) {
            for (Map.Entry<String, String[]> entry : params.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue()[0];

                request.setAttribute(key, value);
            }
            request.setAttribute("result", "error!");

        }   
        
        JobDAOImpl jdao= new JobDAOImpl();
        List<Job> jobs = jdao.list();
        //List<Language> other_languages = dao.list();

        //other_languages.removeAll(mylanguages);
               
        request.setAttribute("jobs", jobs);        
        
        
        String nextJSP = "/WEB-INF/complete/createad.jsp";
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