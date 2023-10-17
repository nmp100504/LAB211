/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Validation {
    Scanner sc = new Scanner(System.in);

    public int getChoice(String msg, int min, int max) {
        int choice = 0;
        String input = "";
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Choice could not be empty. Please enter again!");
                continue;
            } else {
                try {
                    choice = Integer.parseInt(input);
                    //choice must be in range min to max
                    if (choice >= min && choice <= max) {
                        break;
                    } else {
                        System.out.println("Choice must be in range from " + min + " to " + max);
                        continue;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Choice must be positive integer number");
                    continue;
                }

            }
        } while (true);
        return choice;
    }
    
    
}
