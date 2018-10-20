package servlets.HTS;

import dao.definitions.UserDAO;
import dao.UserDAOImpl;

import dao.definitions.AdDAO;
import dao.AdDAOImpl;
import dao.UserApplyAdDAOImpl;
import dao.definitions.UserApplyAdDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import model.Job;
import model.Ad;
import model.UserApplyAd;

/**
 *
 * @author alex
 */
@WebServlet(name = "HTSAd", urlPatterns = {"/ad"})
public class HTSAd extends HttpServlet {

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
            //----------------------- Ad creation------------------------
            //---------------------------------------------------            
            
            
/*             AdDAOImpl dao = new AdDAOImpl();
             Ad entity = new Ad();
             Job job =new Job();
             User user= new User();
             
             job.setJobId(1);
             user.setUserId(1);
             
             

            //DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            //Date fd = formatter.parse(from_date
            //Date sqlDate = new java.sql.Date(.getTime());   
            java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
            
 /*           out.println("<h1>Test create()");
         
            //entity.setAdId(3);
            //entity.setApplicationDeadlineDate(date);
            entity.setDatetimeCreated(date);
            entity.setDescription("adsssssssad");
            entity.setJobId(job);
            entity.setUserId(user);
            entity.setTitle("title3");
            
            
            
            
            try {
                dao.create(entity);
                out.println("<p>Ad created (correct)</p>");
            } catch (Exception ex) {
                out.println("<p>Ad not created (error)</p>");
            }            
            
*/            
            out.println("<p>After party!</p>");
            
            
            
            //***************************************************
            //---------------------------------------------------
            //-----------------------User Apply Ad------------------------
            //---------------------------------------------------

            //UserApplyAdDAOImpl dao2 = new UserApplyAdDAOImpl();

            //DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            //Date fd = formatter.parse(from_date
            //Date sqlDate = new java.sql.Date(.getTime());   
            java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
            
            
            //8a testarw tis listes gia na katalabw ti trexei
        AdDAOImpl addao = new AdDAOImpl();       
        Ad ad = addao.find(1);       
        
        List<UserApplyAd> useradlist;
        //List<UserIsConnectedToUser> networkList1;
        /*networkList = (List<UserIsConnectedToUser>) request.getSession(false).getAttribute("networkList");
        networkList1 = (List<UserIsConnectedToUser>) request.getSession(false).getAttribute("networkList1");*/
        
        User userdetail;
        UserApplyAdDAOImpl uadao = new UserApplyAdDAOImpl();

        useradlist = uadao.findUserAds(ad.getAdId());
        //networkList1 = dao3.find2(me.getUserId());
       
        //AdDAOImpl adao = new AdDAOImpl();

        //List<Ad> adlist = adao.list();
        List<UserApplyAd> mylist = new ArrayList<>();

        Integer connecteduserId;

        if (!(useradlist == null)) {
            out.println("<p>Edw1!</p>"); 
            //for (UserApplyAd nlist : useradlist) {

                //connecteduserId = nlist.getUser1().getUserId();
                //out.println("<p>- " + u.getFirstname()+ " " + u.getSurname()+ " " + u.getPassword() + " </p>");

                for (UserApplyAd list : useradlist) {
                    out.println("<p>Edw2!</p>"); 
                    out.println("<p>!!!- " + list.getAd().getAdId()+ " " + " </p>");
                    if ((list.getAd().getUserId().equals(ad.getAdId()))) {
                        mylist.add(list);
                    }
                }
           // }
        }
        if(!(mylist == null)){
            out.println("<p>Edw3!</p>"); 
                for (UserApplyAd list : mylist) {
                    out.println("<p>Edw4!</p>"); 
                    out.println("<p>???- " + list.getAd().getAdId()+ " " + " </p>");
                    if ((list.getAd().getUserId().equals(ad.getAdId()))) {
                        mylist.add(list);
                    }
                } 
        }
            
            
        out.println("<p>After skatoules!</p>");    
            
            /*
            try {
                dao2.create(1,2, date);
                out.println("<p>Ad created (correct)</p>");
            } catch (Exception ex) {
                out.println("<p>Ad not created (error)</p>");
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
