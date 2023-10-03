/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab105;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validate {

    Scanner sc = new Scanner(System.in);

    public int getInt(String msg, int min, int max) {
        System.out.println(msg);
        while (true) {
            String input = sc.nextLine();
            try {
                int result = Integer.parseInt(input);
                if (result > max || result < min) {
                    System.out.println("int must be in range");
                    continue;
                }
                return result;
            } catch (Exception e) {
                System.out.println("input again");
            }

        }
    }
    public double getDouble(String msg, double min, double max) {
        System.out.println(msg);
        while (true) {
            String input = sc.nextLine();
            try {
                double result = Double.parseDouble(input);
                if (result > max || result < min) {
                    System.out.println("double must be in range");
                    continue;
                }
                return result;
            } catch (Exception e) {
                System.out.println("input again");
            }

        }
    }
    public String getString(String msg, String regex) {
        System.out.println(msg);
        while (true) {
            String input = sc.nextLine();
            try {
                if(!input.matches(regex)){
                    System.out.println("string must follow the pattern");
                    continue;
                }
                
                return input;
            } catch (Exception e) {
                System.out.println("input again");
            }

        }
    }
    public String getDate(String msg, String regex){
        System.out.println(msg);
        while(true){
            String input = sc.nextLine();
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat(regex);
                Date date = dateFormat.parse(input);
                return dateFormat.format(date);
            } catch (Exception e) {
                System.out.println("input again");
            }
        }
    }
}
