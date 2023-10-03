/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab23;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class FruitManagement {

    Scanner sc = new Scanner(System.in);
    int idFruit = 0;
    ArrayList<Fruit> fruitList = new ArrayList<>();
    Hashtable<String, ArrayList<Fruit>> orders = new Hashtable<>();
    int orderId = 1;
    Fruit newFruit = new Fruit();

    public void run() {
        int choice;
        do {
            System.out.println("FRUIT SHOP SYSTEM");
            System.out.println("1. Create fruit");
            System.out.println("2. View orders");
            System.out.println("3. Shopping (for buyers)");
            System.out.println("4. Exit");

            System.out.print("Your option: ");
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Your choice has to be an integer from 1 to 4 !");
                break;
            }

            switch (choice) {
                case 1:
                    createFruit();
                    break;
                case 2:
                    viewOrders();
                    break;
                case 3:
                    shopping();
                    break;
                case 4:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Not an option!");
            }
        } while (choice != 4);
    }

    // toi uu bo nho du lieu
    void createFruit() {
        while (true) {
            System.out.println("Enter fruit information:");

            System.out.print("Name: ");
            newFruit.setName(sc.nextLine());

            System.out.print("Price: ");
            newFruit.setPrice(sc.nextDouble());
            sc.nextLine();
            System.out.print("Quantity: ");

            newFruit.setQuantity(sc.nextInt());
            sc.nextLine();
            System.out.print("Origin: ");
            newFruit.setOrigin(sc.nextLine());
            int id = autoGenerateFruitId();
            newFruit.setId(id);
            fruitList.add(newFruit);
            System.out.println("Added!");
            System.out.println("Do you want to continue ?");
            String continueOption = sc.nextLine();
            if (continueOption.toLowerCase().charAt(0) != 'y') {
                break;
            }
        }

    }

    void viewOrders() {
        System.out.println("Orders list:");
        for (String customerName : orders.keySet()) {
            System.out.println("Customer: " + customerName);
            System.out.println("Product | Quantity | Price | Amount");
            ArrayList<Fruit> fruitInOrder = orders.get(customerName);
            double total = 0;
            for (Fruit fruit : fruitInOrder) {
                System.out.println(fruit.getName() + "\t\t" + fruit.getQuantity() + "\t\t" + fruit.getPrice() + "\t\t" + fruit.getPrice() * fruit.getQuantity());
                total += fruit.getPrice() * fruit.getQuantity();
            }
            System.out.println("Total: " + total + "$");
        }
    }

    void shopping() {
        System.out.println("List of fruits:");
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
        for (Fruit fruit : fruitList) {
            System.out.println("\t" + (fruit.getId() + 1) + "\t\t" + fruit.getName() + "\t\t" + fruit.getOrigin() + "\t\t" + fruit.getPrice());
        }
        System.out.print("Select: ");
        int selectedIndex = sc.nextInt() - 1;
        sc.nextLine();
        if (selectedIndex < 0 || selectedIndex >= fruitList.size()) {
            System.out.println("Not an option!");
            return;
        }
        Fruit selectedFruit = fruitList.get(selectedIndex);
        System.out.println("You selected: " + selectedFruit.getName());
        System.out.print("Please input quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();
        selectedFruit.setQuantity(quantity);
        System.out.print("Do you want to order now (Y/N)? ");
        String orderNow = sc.nextLine();
        if (orderNow.toLowerCase().charAt(0) == 'y') {
            System.out.println(" Product | Quantity | Price | Amount");
            System.out.println("\t" + selectedFruit.getName() + "\t" + selectedFruit.getQuantity() + "\t" + selectedFruit.getPrice() + "\t" + selectedFruit.getQuantity() * selectedFruit.getPrice());
            System.out.println("Total: " + selectedFruit.getQuantity() * selectedFruit.getPrice());
            System.out.print("Input your name: ");
            String customerName = sc.nextLine();

            if (orders.containsKey(customerName)) {
                orders.get(customerName).add(selectedFruit);
            } else {
                ArrayList<Fruit> newOrder = new ArrayList<>();
                newOrder.add(selectedFruit);
                orders.put(customerName, newOrder);
            }
            System.out.println("Ordered.");
        } else {
            System.out.println("Canceled.");
            return;
        }
    }

    int autoGenerateFruitId() {
        return idFruit++;
    }
}
