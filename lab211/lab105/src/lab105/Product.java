/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab105;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Product {
    int id;
    String name;
    String location ;
    double price;
    String expiryDate;
    String manufactureDate;
    String category ;
    String storekeeper;
    String receiptDate;

    public Product() {
    }

    public Product(int id, String name, String location, double price, String expiryDate, String manufactureDate, String category, String storekeeper, String receiptDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.price = price;
        this.expiryDate = expiryDate;
        this.manufactureDate = manufactureDate;
        this.category = category;
        this.storekeeper = storekeeper;
        this.receiptDate = receiptDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStorekeeper() {
        return storekeeper;
    }

    public void setStorekeeper(String storekeeper) {
        this.storekeeper = storekeeper;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", location=" + location + ", price=" + price + ", expiryDate=" + expiryDate + ", manufactureDate=" + manufactureDate + ", category=" + category + ", storekeeper=" + storekeeper + ", receiptDate=" + receiptDate + '}';
    }
    Validate validate = new Validate();
    ProductManagement pm = new ProductManagement();
    public void inputProduct(){
        
    }
}
