package servlets.navigation;

import dao.AdDAOImpl;
import dao.LanguageDAOImpl;
import dao.SkillDAOImpl;
import dao.UserApplyAdDAOImpl;
import dao.UserDAOImpl;
import dao.UserIsConnectedToUserDAOImpl;
import dao.definitions.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Ad;
import model.Language;
import model.Skill;
import model.User;
import model.UserApplyAd;
import model.UserFollowsUser;
import model.UserIsConnectedToUser;

/**
 *
 * @author alex
 */
@WebServlet(name = "ApplicationsServlet", urlPatterns = {"/applications"})
public class ApplicationsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final int k = 3;

        //HttpSession session = request.getSession();
        Map<String, String[]> params = request.getParameterMap();

        User me = (User) request.getSession(false).getAttribute("me");
        UserDAOImpl udao = new UserDAOImpl();
        AdDAOImpl adao = new AdDAOImpl();
        UserApplyAdDAOImpl uaa = new UserApplyAdDAOImpl();
        //List<Ad> myapplications;//= (List<Ad>) request.getSession(false).getAttribute("myapplications");
        //Ad ad=new Ad();        

        List<UserIsConnectedToUser> networkList;
        List<UserIsConnectedToUser> networkList1;

        UserIsConnectedToUserDAOImpl dao3 = new UserIsConnectedToUserDAOImpl();

        try {
            if (!params.isEmpty()) {

                java.sql.Date date = new java.sql.Date(System.currentTimeMillis());

                String sdo = params.get("do")[0];

                if (sdo.equals("add")) {
                    String adId = params.get("adId")[0];
                    Ad ad = adao.find(Integer.parseInt(adId));
                    //myapplications = new ArrayList<>();
                    //                   myapplications.add(ad);
                    uaa.create(me.getUserId(), Integer.parseInt(adId), date);
                    //conadlist.removeAll(myapplications);

                } else if (sdo.equals("notconnectedadd")) {
                    String adId = params.get("adId")[0];
                    Ad ad = adao.find(Integer.parseInt(adId));
                    //myapplications = new ArrayList<>();
//                    myapplications.add(ad);                    
                    uaa.create(me.getUserId(), Integer.parseInt(adId), date);
                    //adlist.removeAll(myapplications);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        networkList = dao3.find(me.getUserId());
        networkList1 = dao3.find2(me.getUserId());

        List<Ad> adlist = adao.list();
        List<Ad> myadlist = udao.find(me.getUserId()).getAdList();
        List<Ad> conadlist = new ArrayList<>();
        List<Ad> my = new ArrayList<>();
        List<UserApplyAd> myapplications = udao.find(me.getUserId()).getUserApplyAdList();

        Integer connecteduserId;

        if (!(networkList == null)) {
            for (UserIsConnectedToUser nlist : networkList) {

                connecteduserId = nlist.getUser1().getUserId();
                //out.println("<p>- " + u.getFirstname()+ " " + u.getSurname()+ " " + u.getPassword() + " </p>");

                for (Ad ad : adlist) {
                    if ((ad.getUserId().getUserId().equals(connecteduserId))) {
                        conadlist.add(ad);
                    }
                }
            }
        }

        if (!(networkList1 == null)) {
            for (UserIsConnectedToUser nlist1 : networkList1) {

                connecteduserId = nlist1.getUser().getUserId();

                for (Ad ad : adlist) {
                    if (ad.getUserId().getUserId().equals(connecteduserId)) {
                        conadlist.add(ad);
                    }
                }
            }
        }
        Integer id;

        if (!(myapplications == null)) {
            for (UserApplyAd list : myapplications) {
                my.add(list.getAd());
            }
        }

        adlist.removeAll(conadlist);
        adlist.removeAll(myadlist);
        conadlist.removeAll(my);
        adlist.removeAll(my);

        if (adlist.size() > k) {
            // kNN
            // ----------------------- find all languages
            LanguageDAOImpl ldao = new LanguageDAOImpl();
            SkillDAOImpl sdao = new SkillDAOImpl();

            List<Language> all_languages = ldao.list();
            List<Skill> all_skills = sdao.list();

            List<Integer> all_language_ids = all_languages.stream().map((Language t) -> t.getLanguageId()).collect(Collectors.toList());
            List<Integer> all_skill_ids = all_skills.stream().map((Skill t) -> t.getSkillId()).collect(Collectors.toList());

            Integer user_pk = me.getUserId();

            double[] uv = udao.buildVector(user_pk, all_language_ids, all_skill_ids);

            List<Ad> recommendedArray = new ArrayList<>();
            List<Double> distanceArray = new ArrayList<>();

            for (Ad ad : adlist) {
                Integer ad_pk = ad.getAdId();
                double[] av = adao.buildVector(ad_pk, all_language_ids, all_skill_ids);

                double distance = distance(av, uv);

                if (recommendedArray.size() < k) {
                    recommendedArray.add(ad);
                    distanceArray.add(distance);
                } else {
                    double max = 0;
                    int maxpos = -1;
                    for (int i = 0; i < recommendedArray.size(); i++) {
                        if (distanceArray.get(i) > max) {
                            max = distanceArray.get(i);
                            maxpos = i;
                        }
                    }

                    if (maxpos >= 0) {
                        if (distance < max) {
                            recommendedArray.set(maxpos, ad);
                            distanceArray.set(maxpos, distance);
                        }
                    }
                }
            }

            adlist.clear();
            adlist.addAll(recommendedArray);
        }

        request.getSession(false).setAttribute("conadlist", conadlist);
        request.getSession(false).setAttribute("adlist", adlist);
        request.getSession(false).setAttribute("networkList", networkList);
        request.getSession(false).setAttribute("networkList1", networkList1);

        request.setAttribute("conadlist", conadlist);
        request.setAttribute("adlist", adlist);
        request.setAttribute("my", my);
        request.setAttribute("networkList", networkList);
        request.setAttribute("networkList1", networkList1);

        String nextJSP = "/WEB-INF/complete/applications.jsp";
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

    private double distance(double[] av, double[] uv) {
        double d = 0;
        int m = av.length;

        for (int i = 0; i < m; i++) {
            d = d + (Math.abs(av[i] - uv[i]));
        }
        return d;
    }

}
