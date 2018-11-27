/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.navigation;

import dao.UserDAOImpl;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import modelxml.Catalog;

/**
 *
 * @author alex
 */
@WebServlet(name = "AdminExportServlet", urlPatterns = {"/admin/export"})
public class AdminExportServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String serializeToXML(User user) {
        StringBuffer out = new StringBuffer();

        out.append("<user>");
        out.append("<name>");
        out.append(user.getFirstname());
        out.append("</name>");
        out.append("</user>");

        return out.toString();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Map<String, String[]> params = request.getParameterMap();

        UserDAOImpl dao = new UserDAOImpl();

        try {
            if (!params.isEmpty()) {
                String sdo = params.get("do")[0];

                ServletOutputStream out = response.getOutputStream();

                Catalog catalog = new Catalog();

                if (sdo.equals("exportall")) {
                    List<User> list = dao.list();

                    for (User u : list) {
                        catalog.add(u);
                    }

                } else if (sdo.equals("exportsome")) {
                    List<User> list = dao.list();

                    String[] values = request.getParameterValues("selectors");

                    if (values != null && values.length > 0) {

                        List<Integer> idlist = Stream.of(values).map(Integer::valueOf).collect(Collectors.toList());

                        for (User u : list) {
                            Integer id = u.getUserId();
                            if (idlist.contains(id)) {
                                catalog.add(u);
                            }
                        }
                    }
                }

                // --------- at this point catalog should have been built
                try {
                    JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
                    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                    jaxbMarshaller.marshal(catalog, out);
                } catch (Exception ex) {
                    System.out.println(ex);
                }

                return;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }

        List<User> list = dao.list();

        request.setAttribute("userlist", list);

        String nextJSP = "/WEB-INF/admin/complete/export.jsp";
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
