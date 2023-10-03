/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab11;

import java.util.Scanner;
import lab11.Number11;

/**
 *
 * @author Admin
 */
public class Lab11 {

    /**
     * @param args the command line arguments
     */
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        boolean continueee = true;
        Number11 num = new Number11();
        do {
            System.out.println("he co so ban dau: 1=bin 2=dec 3=hex");
            int inputBase = getUserChoice(sc);
            System.out.println("he co so chuyen toi: 1=bin 2=dec 3=hex");
            int outputBase = getUserChoice(sc);

            System.out.print("so can chuyen he: ");
            String numValue = sc.nextLine();
            num.setBase(inputBase);
            num.setValue(numValue);
            String value = num.getValue();
            

            System.out.println("so " + value + " chuyen toi he " + outputBase + " la: " + num.convertBase(outputBase));
            System.out.println("tiep tuc ko? (y/n)");
            String continueChoice = sc.nextLine();
            if (continueChoice.equalsIgnoreCase("n")) {
                continueee = false;
            }
        } while (continueee == true);
    }

    public static int getUserChoice(Scanner sc) {
        while (true) {
            System.out.print("lua chon cua ban: ");
            String choice = sc.nextLine();
            int input = Integer.parseInt(choice);
            switch (input) {
                case 1:
                    return 2;
                case 2:
                    return 10;
                case 3:
                    return 16;
                default:
                    System.out.println("khong phu hop");
            }
        }
    }

    public static boolean isChoice(String s) {
        return s.matches("^[1-3]$");
    }
}
