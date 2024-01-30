/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Tung
 */
public class tour {
    private String ID;
    private String name;
    private String destination;
    private int numOfPerson;
    private int numOfDay;
    private int price;
    private String describe;
    private float rating;
    private String image;
    public tour() {
    }

    public tour(String ID, String name, String destination, int numOfPerson, int numOfDay, int price, String describe, float rating, String image) {
        this.ID = ID;
        this.name = name;
        this.destination = destination;
        this.numOfPerson = numOfPerson;
        this.numOfDay = numOfDay;
        this.price = price;
        this.describe = describe;
        this.rating = rating;
        this.image = image;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNumOfPerson() {
        return numOfPerson;
    }

    public void setNumOfPerson(int numOfPerson) {
        this.numOfPerson = numOfPerson;
    }

    public int getNumOfDay() {
        return numOfDay;
    }

    public void setNumOfDay(int numOfDay) {
        this.numOfDay = numOfDay;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    

    @Override
    public String toString() {
        return "tour{" + "ID=" + ID + ", name=" + name + ", destination=" + destination + ", numOfPerson=" + numOfPerson + ", numOfDay=" + numOfDay + ", price=" + price + ", describe=" + describe + ", rating=" + rating + '}';
    }
    
    
}
