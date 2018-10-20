package servlets.navigation;

import dao.AdDAOImpl;
import dao.UserApplyAdDAOImpl;
import dao.UserDAOImpl;
import dao.UserIsConnectedToUserDAOImpl;
import dao.definitions.AdDAO;
import dao.definitions.UserApplyAdDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import model.UserApplyAd;
import model.User;
import model.Job;
import model.UserIsConnectedToUser;

/**
 *
 * @author alex
 */
@WebServlet(name = "ExamineDetailsServlet", urlPatterns = {"/examinedetails"})
public class ExamineDetailsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, String[]> params = request.getParameterMap();

        Integer adid = Integer.parseInt(request.getParameter("id").toString());

        User me = (User) request.getSession(false).getAttribute("me");

        AdDAOImpl addao = new AdDAOImpl();
        UserDAOImpl udao = new UserDAOImpl();
        UserApplyAdDAOImpl uaa = new UserApplyAdDAOImpl();

        try {
            if (!params.isEmpty()) {

                java.sql.Date date = new java.sql.Date(System.currentTimeMillis());

                String sdo = params.get("do")[0];
                AdDAOImpl adao = new AdDAOImpl();

                if (sdo.equals("accept")) {
                    Ad ad = new Ad();
                    //UserIsConnectedToUserDAOImpl uudao = new UserIsConnectedToUserDAOImpl();
                    //UserConnectionRequestUserDAOImpl rdao = new UserConnectionRequestUserDAOImpl();

                    String userId = params.get("userId")[0];
                    String adId = params.get("adId")[0];

                    //kanw remove to application
                    uaa.remove(Integer.parseInt(userId), Integer.parseInt(adId));

                    //na kanw remove to ad
                    //ad = adao.find(Integer.parseInt(adId));
                    adao.remove(Integer.parseInt(adId));

                    String nextJSP = "/WEB-INF/complete/examinedetails.jsp";
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
                    dispatcher.forward(request, response);
                    return;

                    //uudao.create(Integer.parseInt(userId), me.getUserId(), date);
                    //rdao.stopRequest(Integer.parseInt(userId), me.getUserId());
                } else if (sdo.equals("deny")) {
                    //UserConnectionRequestUserDAOImpl rdao = new UserConnectionRequestUserDAOImpl();
                    String userId = params.get("userId")[0];
                    String adId = params.get("adId")[0];
                    uaa.remove(Integer.parseInt(userId), Integer.parseInt(adId));
                    //rdao.stopRequest(Integer.parseInt(userId), me.getUserId());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //H aggelia mou
        Ad myad = addao.find(adid);
        //Oles oi aithseis
        List<UserApplyAd> applications = myad.getUserApplyAdList();

        //request.getSession(false).setAttribute("myuseradlist", applications);
        request.setAttribute("myuseradlist", applications);

        //request.setAttribute("adid", ad);     
        String nextJSP = "/WEB-INF/complete/examinedetails.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);

        /*
        for(Ad ad: myads){
            for(i=0; i<size; i++){
             if(ad.getSkill().getToolsAndTechnologyId().equals(other_skills.get(i).getToolsAndTechnologyId())){
              //other_skills.remove(skill.getSkill());
              other.add(skill.getSkill());             
             }
             
            }
        } */
 /*
        
        Ad ad = addao.find(adid);       
        
        List<UserApplyAd> useradlist;

        
        User userdetail;
        UserApplyAdDAOImpl uadao = new UserApplyAdDAOImpl();

        useradlist = uadao.findUserAds(ad.getAdId());
        //networkList1 = dao3.find2(me.getUserId());
       
        //AdDAOImpl adao = new AdDAOImpl();

        //List<Ad> adlist = adao.list();
        List<UserApplyAd> mylist = new ArrayList<>();

        Integer connecteduserId;

        if (!(useradlist == null)) {
            //for (UserApplyAd nlist : useradlist) {

                //connecteduserId = nlist.getUser1().getUserId();
                //out.println("<p>- " + u.getFirstname()+ " " + u.getSurname()+ " " + u.getPassword() + " </p>");

                for (UserApplyAd nad : useradlist) {
                    if ((nad.getAd().getUserId().equals(me.getUserId()))) {
                        mylist.add(nad);
                    }
                }
           // }
        }        
        
       
        
        request.getSession(false).setAttribute("myuseradlist", mylist);
        request.setAttribute("myuseradlist", mylist);         
        
        
        
        
                
        //request.setAttribute("adid", ad);     

        
        String nextJSP = "/WEB-INF/complete/examinedetails.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);*/
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
