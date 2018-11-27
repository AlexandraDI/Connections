package servlets.HTS;

import dao.AdDAOImpl;
import dao.UserApplyAdDAOImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
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
          out.println("<p>After party!</p>");
 
            java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
            
            
        //8a testarw tis listes gia na katalabw ti trexei
        AdDAOImpl addao = new AdDAOImpl();       
        Ad ad = addao.find(1);       
        
        List<UserApplyAd> useradlist;
        
        User userdetail;
        UserApplyAdDAOImpl uadao = new UserApplyAdDAOImpl();

        useradlist = uadao.findUserAds(ad.getAdId());

        List<UserApplyAd> mylist = new ArrayList<>();

        Integer connecteduserId;

        if (!(useradlist == null)) {

                for (UserApplyAd list : useradlist) {
                    out.println("<p>!!!- " + list.getAd().getAdId()+ " " + " </p>");
                    if ((list.getAd().getUserId().equals(ad.getAdId()))) {
                        mylist.add(list);
                    }
                }
        }
        if(!(mylist == null)){
                for (UserApplyAd list : mylist) { 
                    out.println("<p>???- " + list.getAd().getAdId()+ " " + " </p>");
                    if ((list.getAd().getUserId().equals(ad.getAdId()))) {
                        mylist.add(list);
                    }
                } 
        }
            
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
