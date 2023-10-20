
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Itemlist {

    ArrayList<Order> itemList;
    float total = 0 ; 

    public Itemlist() {
        this.itemList = new ArrayList<>();
    }

    public Itemlist(ArrayList<Order> itemList) {
        this.itemList = itemList;
    }
    public void additem(Order newOrder){
        itemList.add(newOrder);
        total = total + newOrder.getAmount(); 
    }
    public void displayItemlist() {
        int count = 1;
        float total = 0;
        System.out.printf("%15s|%15s|%15s|%15s", "Product", "Quantity", "Price", "Amount\n");
        for (Order order : itemList) {
            System.out.print(count + ". ");
            count++;
            order.displayOrder();
            total += order.getAmount();
        }
        System.out.println("Total: " + total);
    }
    public ArrayList<Order> getItemlist(){
        return this.itemList;
    }
    
}
