/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Logger;
import model.account;
import model.book;
import model.dest;
import model.tour;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author Tung
 */
public class DAO extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<tour> getAllTour() {
        List<tour> list = new ArrayList<>();
        String query = "select * from tour";
        try {
            conn = new DBContext().connection; // mo ket noi
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new tour(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getFloat(8), rs.getString(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<dest> getAllDest() {
        List<dest> list = new ArrayList<>();
        String query = "select * from dest";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new dest(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<tour> getHighestRateTour() {
        List<tour> list = new ArrayList<>();
        String query = "SELECT * FROM tour WHERE rating = (SELECT MAX(Rating) FROM tour)";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new tour(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getFloat(8), rs.getString(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<tour> getfilterTour(String country, String numofperson, String price, String duration) {
        String query = "select * from tour where ID like 'T%'";

        if (!country.equals("nothing")) {
            query = query + " and destination like '%" + country + "%'";
        }

        if (numofperson.equals("1person")) {
            query = query + " and (1 <= numOfPerson and numOfPerson <= 2)";
        }
        if (numofperson.equals("3person")) {
            query = query + " and (3 <= numOfPerson and numOfPerson <= 4)";
        }
        if (numofperson.equals("5person")) {
            query = query + " and (5 <= numOfPerson and numOfPerson <= 7)";
        }

        if (price.equals("1price")) {
            query = query + " and price < 1000";
        }
        if (price.equals("2price")) {
            query = query + " and (1000 <= price and price <= 2000)";
        }
        if (price.equals("3price")) {
            query = query + " and price > 2000";
        }

        if (duration.equals("3dur")) {
            query = query + " and (3 <= numOfDay and numOfDay <= 5)";
        }
        if (duration.equals("6dur")) {
            query = query + " and (6 <= numOfDay and numOfDay <= 10)";
        }
        if (duration.equals("10dur")) {
            query = query + " and numOfDay > 10";
        }
//        System.out.println(query);
        List<tour> list = new ArrayList<>();
        try {
            conn = new DBContext().connection; // mo ket noi
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new tour(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getFloat(8), rs.getString(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public String getQuery(String country, String numofperson, String price, String duration) {
        String query = "select * from tour where ID like 'T%'";

        if (!country.equals("nothing")) {
            query = query + " and destination like '%" + country + "%'";
        }

        if (numofperson.equals("1person")) {
            query = query + " and (1 <= numOfPerson and numOfPerson <= 2)";
        }
        if (numofperson.equals("3person")) {
            query = query + " and (3 <= numOfPerson and numOfPerson <= 4)";
        }
        if (numofperson.equals("5person")) {
            query = query + " and (5 <= numOfPerson and numOfPerson <= 7)";
        }

        if (price.equals("1price")) {
            query = query + " and price < 1000";
        }
        if (price.equals("2price")) {
            query = query + " and (1000 <= price and price <= 2000)";
        }
        if (price.equals("3price")) {
            query = query + " and price > 2000";
        }

        if (duration.equals("3dur")) {
            query = query + " and (3 <= numOfDay and numOfDay <= 5)";
        }
        if (duration.equals("6dur")) {
            query = query + " and (6 <= numOfDay and numOfDay <= 10)";
        }
        if (duration.equals("10dur")) {
            query = query + " and numOfDay > 10";
        }
        return query;
    }

    public String getSortQuery(String sortoption) {
        if (sortoption.equals("ratedesc")) {
            return " order by rating desc";
        }
        if (sortoption.equals("rateasc")) {
            return " order by rating asc";
        }
        if (sortoption.equals("pricedesc")) {
            return " order by price desc";
        }
        if (sortoption.equals("priceasc")) {
            return " order by price asc";
        }
        if (sortoption.equals("durdesc")) {
            return " order by numOfDay desc";
        }
        if (sortoption.equals("durasc")) {
            return " order by numOfDay asc";
        }
        if (sortoption.equals("nopdesc")) {
            return " order by numOfPerson desc";
        }
        if (sortoption.equals("nopasc")) {
            return " order by numOfPerson asc";
        }
        return null;
    }

    public List<tour> getTourByQuery(String query) {

        List<tour> list = new ArrayList<>();
        try {
            conn = new DBContext().connection; // mo ket noi
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new tour(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getFloat(8), rs.getString(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void setBooking(String name, String email, String phone, String date, String selectedtour, String username) {
        String query;
        query = "INSERT INTO booking (cusName, cusMail, cusPhone, startDate, TourID, accUsername) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, date);
            ps.setString(5, selectedtour);
            ps.setString(6, username);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }

    public book getLastBook() {
        book lastbook = new book();
        String query = "SELECT TOP 1 * FROM booking ORDER BY bookID DESC";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                lastbook = new book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } catch (Exception e) {
        }
        return lastbook;
    }

    public tour getBookTour(String selectedtour) {
        tour tour = new tour();
        String query = "select * from tour where ID = ?";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, selectedtour);
            rs = ps.executeQuery();
            while (rs.next()) {
                tour = new tour(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getFloat(8), rs.getString(9));
            }
        } catch (Exception e) {
        }
        return tour;
    }

    public List<tour> getTourByDes(String des) {
        List<tour> list = new ArrayList<>();
        String query = "select * from tour where destination = ?";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, des);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new tour(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getFloat(8), rs.getString(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public boolean isAdmin(String username, String pass) {
        account acc = new account();
        String query = "select * from account "
                + "where "
                + "accUsername = ? "
                + "and accPassword = ?";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                acc = new account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6));
            }
        } catch (Exception e) {
            java.util.logging.Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        if (acc.getIsAdmin() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isUser(String username, String pass) {
        account acc = new account();
        String query = "select * from account "
                + "where "
                + "accUsername = ? "
                + "and accPassword = ?";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                acc = new account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6));
            }
        } catch (Exception e) {
        }
        if (acc.getIsAdmin() == 0 && acc.getAccUsername() != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean createUserAccount(String email, String username, String pass, String phone) {
        if (isValidGmail(email)) {
            java.util.logging.Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, "Email is invalid!");
            return false;
        }
        if (isValidUsername(username)) {
            java.util.logging.Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, "Username is invalid!");
            return false;
        }
        if (isValidPassword(pass)) {
            java.util.logging.Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, "Password is invalid!");
            return false;
        }
        if (isValidPhone(phone)) {
            java.util.logging.Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, "Phone number is invalid!");
            return false;
        }
        if (checkExisted(email, "")) {
            java.util.logging.Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, "Email already existed!");
            return false;
        }
        if (checkExisted("", username)) {
            java.util.logging.Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, "Username already existed!");
            return false;
        }
        String query = "insert into account"
                + "(accMail, "
                + "accUsername, "
                + "accPassword, "
                + "accPhone, "
                + "isAdmin) \n"
                + "values (?, ?, ?, ?, 0)";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, username);
            ps.setString(3, pass);
            ps.setString(4, phone);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
        if (checkExisted(email, username)) {
            return true;
        } else {
            return false;
        }
    }

    public account getExistAccount(String email, String username) {
        account acc = new account();
        String query = "select * from account"
                + " where accMail = ? "
                + "or accUsername = ?";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                acc = new account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6));
            }
        } catch (Exception e) {
        }
        return acc;
    }

    public boolean checkExisted(String email, String username) {
        account acc = getExistAccount(email, username);
        if (acc.getAccMail() == null || acc.getAccUsername() == null) {
            return false;
        } else {
            return true;
        }
    }

    public List<book> getBookByUser(String username) {
        List<book> list = new ArrayList<>();
        String query = "select b.bookID, b.cusName, b.cusMail, b.cusPhone, b.startDate, b.TourID from booking b join account c on b.accUsername = c.accUsername where c.accUsername = ?";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new book(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<tour> getTourByListBook(List<book> list) {
        List<tour> tour = new ArrayList<>();
        for (book li : list) {
            tour tr = getBookTour(li.getTourID());
            tour.add(tr);
        }
        return tour;
    }

    public void updateBook(String name, String mail, String phone, String date, int bookID) {
        String query = "update booking set cusName = ?, cusMail = ?, cusPhone = ? , startDate = ? where bookID = ?";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, mail);
            ps.setString(3, phone);
            ps.setString(4, date);
            ps.setInt(5, bookID);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }

    public void deleteBook(String bookid) {
        int bookID = Integer.parseInt(bookid);
        String query = "delete from booking where bookID = ?";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setInt(1, bookID);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }

    public void addTour(String ID, String name, String dest, int numofperson, int numofday, String describe, int price, double rating, String image) {
        String query = "insert into tour(ID, [name], destination, numOfPerson, numOfDay, describe, price, rating, image) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, ID);
            ps.setString(2, name);
            ps.setString(3, dest);
            ps.setInt(4, numofperson);
            ps.setInt(5, numofday);
            ps.setString(6, describe);
            ps.setInt(7, price);
            ps.setDouble(8, rating);
            ps.setString(9, image);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            Logger Log = LogManager.getLogger();
            Log.error("SQL Exception: " + e.getMessage());
            Log.error("SQL State: " + e.getSQLState());
            Log.error("Vendor Error Code: " + e.getErrorCode(), e);
        }
    }

    public void delTour(String ID) {
        String query = "delete from tour where ID = ?";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, ID);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }

    public boolean isValidUsername(String username) {
        if (username == null || username.isEmpty()) {
            return false;
        }
        if (username.length() < 2 || username.length() > 12) {
            return false;
        }
        if (!Character.isLetter(username.charAt(0))) {
            return false;
        }
        for (char c : username.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidPassword(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        if (password.length() < 6 || password.length() > 12) {
            return false;
        }
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{6,}$";
        if (!password.matches(regex)) {
            return false;
        }
        return true;
    }

    public boolean isValidGmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        if (!email.matches(regexPattern)) {
            return false;
        }
        return true;
    }

    public boolean isValidPhone(String phone) {
        if (phone == null || phone.isEmpty()) {
            return false;
        }
        if (phone.length() != 10) {
            return false;
        }
        if (phone.charAt(0) != '0') {
            return false;
        }
        for (char c : phone.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
//        List<tour> list = dao.getAllTour();
//        for (tour o : list) {
//            System.out.println(o);
//        }
//
//        List<dest> list2 = dao.getAllDest();
//        for (dest o1 : list2) {
//            System.out.println(o1);
//        }
//
//        book bk = dao.getLastBook();
//        System.out.println(bk);
//
//        tour tr = dao.getBookTour("T000001");
//        System.out.println(tr);
//
        System.out.println(dao.getExistAccount("admin@gmail", "admin"));
//        
//        List<book> byuser = dao.getBookByUser("tamtamtam");
//        System.out.println("---123---");
//        System.out.println(byuser);

    }

}
