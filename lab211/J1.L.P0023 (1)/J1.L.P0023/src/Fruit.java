
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Fruit {

    private String fruitID;
    private String fruitName;
    private float price;
    private int quantity;
    private String origin;

    public Fruit() {
    }

    public Fruit(String fruitID, String fruitName, float price, int quantity, String origin) {
        this.fruitID = fruitID;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public Fruit(String fruitID, String fruitName, float price, int quantity) {
        this.fruitID = fruitID;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;

    }

    public void createFruit() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter fruit ID: ");
        setFruitID(scan.nextLine().trim());
        System.out.print("Enter fruit Name: ");
        setFruitName(scan.nextLine().trim());
        System.out.print("Enter fruit Price: ");
        setPrice(Float.parseFloat(scan.nextLine().trim()));
        System.out.print("Enter fruit Quantity: ");
        setPrice(Integer.parseInt(scan.nextLine().trim()));
        System.out.print("Enter fruit Origin: ");
        setOrigin(scan.nextLine().trim());
    }
    public void displayFruit(){
        System.out.printf("%15s%20s%15.2f\n",getFruitName(),getOrigin(),getPrice());
    }

    public String getFruitID() {
        return fruitID;
    }

    public void setFruitID(String fruitID) {
        this.fruitID = fruitID.toUpperCase();
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

}
