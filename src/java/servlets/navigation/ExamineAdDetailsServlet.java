package servlets.navigation;

import dao.AdDAOImpl;
import dao.JobDAOImpl;
import dao.UserDAOImpl;
import dao.definitions.AdDAO;
import dao.definitions.UserDAO;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Ad;
import model.Job;
import model.User;

/**
 *
 * @author alex
 */
@WebServlet(name = "ExamineAdDetailsServlet", urlPatterns = {"/examineaddetails"})
public class ExamineAdDetailsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        Integer adId = Integer.parseInt(request.getParameter("adId").toString());
        
         Map<String, String[]> params = request.getParameterMap();

        try {
            if (!params.isEmpty()) {
                User user = (User) request.getSession(false).getAttribute("me");
                

                String title = params.get("title")[0];
                String desc = params.get("desc")[0];  
                String jobid = params.get("jobId")[0];  

                AdDAO dao = new AdDAOImpl();
                UserDAO udao = new UserDAOImpl();
                Job job = new Job();               

                job.setJobId(Integer.parseInt(jobid));

                Ad ad = new Ad();
                ad.setDescription(desc);
                ad.setJobId(job);
                ad.setUserId(user);
                ad.setTitle(title);                

                
                //update
                dao.update(adId, ad);

                request.setAttribute("result", "Ad updated!");

            }
        } catch (Exception ex) {
            for (Map.Entry<String, String[]> entry : params.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue()[0];

                request.setAttribute(key, value);
            }

        }       
        
        Ad ad= new Ad();
        
        AdDAOImpl addao= new AdDAOImpl();
        ad=addao.find(adId);
        
        JobDAOImpl jdao= new JobDAOImpl();
        List<Job> jobs = jdao.list();
        
        request.setAttribute("ad", ad);
               
        request.setAttribute("jobs", jobs); 
        
        
        String nextJSP = "/WEB-INF/complete/examineaddetails.jsp";
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