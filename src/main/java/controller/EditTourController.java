package controller;

import dal.DAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.tour;

public class EditTourController extends HttpServlet {

    private static final String BOOK_ID_ATTRIBUTE = "bookid";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
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
        } catch (Exception e) {
            // Handle exception
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String date = request.getParameter("date");
        DAO dao = new DAO();
        try {
            HttpSession session = request.getSession();
            String bookID = session.getAttribute(BOOK_ID_ATTRIBUTE).toString();
            int bookIDint = Integer.parseInt(bookID);
            dao.updateBook(name, email, phone, date, bookIDint);
            response.sendRedirect("editsuccess");
        } catch (Exception e) {
            // Handle exception
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("edit")) {
            String name = request.getParameter("cusName");
            String mail = request.getParameter("cusMail");
            String phone = request.getParameter("cusPhone");
            String sdate = request.getParameter("startDate");
            HttpSession session = request.getSession();
            String bookid = request.getParameter("bookid");
            session.setAttribute(BOOK_ID_ATTRIBUTE, bookid);
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
                // Handle exception
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}