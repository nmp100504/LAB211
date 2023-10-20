
import java.util.ArrayList;
import java.util.List;
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
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ManageFruit manageFruit = new ManageFruit();
        ManageOrder manageOrder = new ManageOrder();
        manageFruit.addFruit(new Fruit("F1", "Tao", 2, 5, "Lao"));
        manageFruit.addFruit(new Fruit("F2", "Buoi", 15, 10, "China"));
        manageFruit.addFruit(new Fruit("F4", "Cam", 5, 10, "Lao"));
        manageFruit.addFruit(new Fruit("F3", "Nho", 10, 10, "thai"));
        manageFruit.addFruit(new Fruit("F5", "Mit", 10, 10, "campuchia"));
        while (true) {
            System.out.println("FRUIT SHOP SYSTEM\n"
                    + "1. Create Fruit\n"
                    + "2. View orders\n"
                    + "3. Shopping (for buyer)\n"
                    + "4. Exit\n"
                    + " (Please choose 1 to create product, 2 to view order, 3 for shopping, 4 to Exit program).");
            int choice = Integer.parseInt(scan.nextLine().trim());
            switch (choice) {
                case 1:
                    while (true) {
                        Fruit newFruit = new Fruit();
                        newFruit.createFruit();
                        manageFruit.addFruit(newFruit);
                        System.out.println("Do you want to continue (Y/N)?");
                        String input1 = scan.nextLine().trim();
                        if (input1.equalsIgnoreCase("n")) {
                            manageFruit.displayFruitList();
                            break;
                        }
                    }
                case 2:
                    manageOrder.viewOrder();
                    break;
                case 3:
                    Itemlist newItemlist = new Itemlist();
                    while (true) {
                        manageFruit.displayFruitList();
                        System.out.print("Your choice: ");
                        int choiceFruit = Integer.parseInt(scan.nextLine().trim());
                        Fruit selectedFruit = manageFruit.getFruitbychoice(choiceFruit);
                        System.out.println("you choosed: " + selectedFruit.getFruitName());
                        if (selectedFruit != null) {
                            System.out.print("Please input quantity: ");
                            int quantity = Integer.parseInt(scan.nextLine().trim());
                            if (selectedFruit.getQuantity() < quantity) {
                                System.out.println("not enough fruit in stock");
                                System.out.println("Stock only have " + selectedFruit.getQuantity() + selectedFruit.getFruitName() + " left!");

                            } else {
                                selectedFruit.setQuantity(selectedFruit.getQuantity() - quantity); 
                                Order newOder = new Order(selectedFruit.getFruitID(), selectedFruit.getFruitName(), selectedFruit.getPrice(), quantity);
                                for (Order order : newItemlist.getItemlist()) {
                                    if (order.getFruitName().equalsIgnoreCase(newOder.getFruitName()) && order.getFruitID().equalsIgnoreCase(newOder.getFruitID())) {
                                        newOder.setOrderQuantity(order.getOrderQuantity() + newOder.getOrderQuantity());
                                        newOder.setAmount(order.getAmount() + newOder.getAmount());
                                    }
                                }

                                newItemlist.additem(newOder);
                                newItemlist.displayItemlist();
                                System.out.println("Do you want to order now (Y/N)");
                                String input2 = scan.nextLine().trim();
                                if (input2.equalsIgnoreCase("y")) {
                                    System.out.print("Enter your name: ");
                                    String name = scan.nextLine().trim();

                                    manageOrder.addCustomerOrder(name, newItemlist);
                                    break;

                                }
                            }
                        }

                    }
                    break;

                case 4:
                    return;

            }
        }
    }

}
