
import java.util.ArrayList;
import java.util.Hashtable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class ManageOrder {

    Hashtable<String, Itemlist> orderTable;
    

    public ManageOrder() {
        this.orderTable = new Hashtable<>();
    }

    public ManageOrder(Hashtable<String, Itemlist> orderTable) {
        this.orderTable = orderTable;
    }

    public void addCustomerOrder(String name, Itemlist itemlist) {
        orderTable.put(name, itemlist);

    }

    public void viewOrder() {
        if (orderTable.isEmpty()) {
            System.out.println("No oder recently!");
            return;
        }
        for (String name : orderTable.keySet()) {
            System.out.println("Customer: " + name);
            Itemlist temp = orderTable.get(name);
            temp.displayItemlist();
        }

    }

}
