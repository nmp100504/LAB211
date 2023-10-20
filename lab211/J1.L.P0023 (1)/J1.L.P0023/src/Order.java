/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Order {

    private String fruitID;
    private Float Amount;
    private String fruitName;
    private float Price;
    private int orderQuantity;

    public Order() {
    }

    public Order(String fruitID, String fruitName, float Price, int orderQuantity) {
        this.fruitID = fruitID;
        
        this.Amount = Price*orderQuantity;
        this.fruitName = fruitName;
        this.Price = Price;
        this.orderQuantity = orderQuantity;
    }

    public String getFruitID() {
        return fruitID;
    }

    public void setFruitID(String fruitID) {
        this.fruitID = fruitID;
    }

    public Float getAmount() {
        return Amount;
    }

    public void setAmount(Float Amount) {
        this.Amount = Amount;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public void displayOrder() {
        System.out.printf("%10s|%15d|%15.2f|%15.2f\n", getFruitName(), getOrderQuantity(), getPrice(), getAmount());
    }

}
