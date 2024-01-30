/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.tour;

/**
 *
 * @author Tung
 */
public class AdminAddTourController extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            DAO dao = new DAO();
            HttpSession session = request.getSession();
            try {
                String username = session.getAttribute("user").toString();
                boolean isLogged = (username != null && !username.isEmpty());
                request.setAttribute("isLogged", isLogged);
            } catch (Exception e) {
            }
            List<tour> list = dao.getAllTour();
            request.setAttribute("listtour", list);
            request.getRequestDispatcher("admin.jsp").forward(request, response);
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
//        processRequest(request, response);
        String ID = request.getParameter("ID");
        String name = request.getParameter("name");
        String dest = request.getParameter("dest");
        String nop = request.getParameter("numofperson");
        int numofperson = Integer.parseInt(nop);
        String nod = request.getParameter("numofday");
        int numofday = Integer.parseInt(nod);
        String pr = request.getParameter("price");
        int price = Integer.parseInt(pr);
        String describe = request.getParameter("describe");
        String rt = request.getParameter("rating");
        float rating = Float.parseFloat(rt);
        String image = request.getParameter("image");
        try {
            DAO dao = new DAO();
            dao.addTour(ID, name, dest, numofperson, numofday, describe, price, rating, image);
            request.setAttribute("addsuccess", "Add tour successfully!");
            processRequest(request, response);
        } catch (Exception e) {

        }

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
