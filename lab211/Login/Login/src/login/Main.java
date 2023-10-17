/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author PC
 */
public class Main {

    public static void main(String[] args) {
        Login loginSystem = new Login();
        Validation v = new Validation();
        do {
            displayMenu();
            int choice = v.getChoice("Please choice one option:", 1, 3);
            switch (choice) {
                case 1:
                    loginSystem.VietnameseSystem();
                    break;
                case 2:
                    loginSystem.EnglishSystem();
                    break;
                case 3:
                    return;
            }
        } while (true);
    }
    
    static void displayMenu() {
        System.out.println("-------Login Program-------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
    }
}
