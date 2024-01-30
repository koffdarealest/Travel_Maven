/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Tung
 */
public class account {
    
    public int accID;
    public String accMail;
    public String accUsername;
    public String accPassword;
    public String accPhone;
    public int isAdmin;

    public account() {
    }

    public account(int accID, String accMail, String accUsername, String accPassword, String accPhone, int isAdmin) {
        this.accID = accID;
        this.accMail = accMail;
        this.accUsername = accUsername;
        this.accPassword = accPassword;
        this.accPhone = accPhone;
        this.isAdmin = isAdmin;
    }

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    public String getAccMail() {
        return accMail;
    }

    public void setAccMail(String accMail) {
        this.accMail = accMail;
    }

    public String getAccUsername() {
        return accUsername;
    }

    public void setAccUsername(String accUsername) {
        this.accUsername = accUsername;
    }

    public String getAccPassword() {
        return accPassword;
    }

    public void setAccPassword(String accPassword) {
        this.accPassword = accPassword;
    }

    public String getAccPhone() {
        return accPhone;
    }

    public void setAccPhone(String accPhone) {
        this.accPhone = accPhone;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "account{" + "accID=" + accID + ", accMail=" + accMail + ", accUsername=" + accUsername + ", accPassword=" + accPassword + ", accPhone=" + accPhone + ", isAdmin=" + isAdmin + '}';
    }

    
    
    
}
