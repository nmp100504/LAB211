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
public class Account {

    private String acount;
    private String passwords;

    public Account() {
    }

    public Account(String acount, String passwords) {
        this.acount = acount;
        this.passwords = passwords;
    }

    public String getAcount() {
        return acount;
    }

    public void setAcount(String acount) {
        this.acount = acount;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }
    
    Scanner sc = new Scanner(System.in);
    public String getAcountNumber(String msg, String formatMsg) {
        String input;
        do {
            System.out.print(msg);
            try {
                input = sc.nextLine();
                if (input.matches("^[0-9]{10}$")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception ex) {
                System.out.println(formatMsg);
            }
        } while (true);
        return input;
    }

    public String getPassword(String msg, String formatMsg) {
        String input;
        do {
            System.out.print(msg);
            try {
                input = sc.nextLine();
                if (input.length() >= 8 && input.length() <= 31) {
                    if (input.matches("^[a-zA-Z0-9]*(([a-zA-Z]+[0-9]+)|[0-9]+[a-zA-Z]+)[a-zA-Z0-9]*$")) {
                        break;
                    } else {
                        throw new Exception();
                    }
                } else {
                    throw new Exception();
                }
            } catch (Exception ex) {
                System.out.println(formatMsg);
            }
        } while (true);

        return input;
    }
}
