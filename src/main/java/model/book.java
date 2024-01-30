/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Tung
 */
public class book {
    int bookID;
    String cusName;
    String cusMail;
    String cusPhone;
    String startDate;
    String TourID;

    public book() {
    }

    public book(int bookID, String cusName, String cusMail, String cusPhone, String startDate, String TourID) {
        this.bookID = bookID;
        this.cusName = cusName;
        this.cusMail = cusMail;
        this.cusPhone = cusPhone;
        this.startDate = startDate;
        this.TourID = TourID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusMail() {
        return cusMail;
    }

    public void setCusMail(String cusMail) {
        this.cusMail = cusMail;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTourID() {
        return TourID;
    }

    public void setTourID(String TourID) {
        this.TourID = TourID;
    }

    @Override
    public String toString() {
        return "book{" + "bookID=" + bookID + ", cusName=" + cusName + ", cusMail=" + cusMail + ", cusPhone=" + cusPhone + ", startDate=" + startDate + ", TourID=" + TourID + '}';
    }
    
    
}
