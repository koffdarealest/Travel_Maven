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
public class EditTourController extends HttpServlet {

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
            HttpSession session = request.getSession();
            try {
                String username = session.getAttribute("user").toString();
                boolean isLogged = (username != null && !username.isEmpty());
                request.setAttribute("isLogged", isLogged);
            } catch (Exception e) {
            }
            DAO dao = new DAO();
            List<tour> list = dao.getAllTour();
            request.setAttribute("listtour", list);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
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
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String date = request.getParameter("date");
        DAO dao = new DAO();
        try {
            HttpSession session = request.getSession();
            String bookID = session.getAttribute("bookid").toString();
            int bookIDint = Integer.parseInt(bookID);
            dao.updateBook(name, email, phone, date, bookIDint);
            response.sendRedirect("editsuccess");
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
//        processRequest(request, response);
        String action = request.getParameter("action");
        if (action.equals("edit")) {
            String name = request.getParameter("cusName");
            String mail = request.getParameter("cusMail");
            String phone = request.getParameter("cusPhone");
            String sdate = request.getParameter("startDate");
            HttpSession session = request.getSession();
            String bookid = request.getParameter("bookid");
            session.setAttribute("bookid", bookid);
            request.setAttribute("name", name);
            request.setAttribute("mail", mail);
            request.setAttribute("phone", phone);
            request.setAttribute("sdate", sdate);
            processRequest(request, response);
        } 
        if (action.equals("delete")) {
            String bookid = request.getParameter("bookid");
            DAO dao = new DAO();
            try {
                dao.deleteBook(bookid);
                response.sendRedirect("editsuccess");
            } catch (Exception e) {
            }
        }

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
