/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0021_hoangvan;

import java.util.Scanner;

/**
 *
 * @author Hoangvan
 */
public class Validation {
    private Scanner sc;
    
   public Validation() {
       sc = new Scanner(System.in);
   }

    public int inputInt() {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Not integer, please re-input");
                continue;
            }
            break;
        }
        return input;
    }

    public String inputString() {
        String input;
        while (true) {
            try {
                input = sc.nextLine();
                return input;
            } catch (NullPointerException e) {
                System.out.println("Mustn't be empty, please re-enter");
            }
        }
    }



public boolean inputYN() {
        String input;
        while (true) {
            try {
                input = sc.nextLine().trim().toLowerCase();
                if (input.matches("y")) {
                    return true;
                }
                if (input.matches("n")) {
                    return false;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Must be 'Y' or 'N', re-enter");
                continue;
            }
        }
    }

    public boolean inputUD() {
        String input;
        while (true) {
            try {
                input = sc.nextLine().trim().toLowerCase();
                if (input.matches("u")) {
                    return true;
                } else if (input.matches("d")) {
                    return false;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Must be 'U' or 'D'");
                continue;
            }
        }
    }

    public String inputCourseName() {
        String input;
        while (true) {
            try {
                input = sc.nextLine().trim().toLowerCase();
                switch (input) {
                    case "j":
                    case "java":
                        return "Java";
                    case "c":
                    case "c++":
                    case "c/c++":
                        return "C/C++";
                    case "net":
                    case ".net":
                        return ".net";
                    default:
                        throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("No such sourse, re-input");
                continue;
            }
        }
    }
}
//input int
//input string
//input ud
//intput yn
//input coursename
