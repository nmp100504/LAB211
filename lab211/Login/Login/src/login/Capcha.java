/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Capcha {
    String finalCapcha = "";

    String createCapcha() {
        String string = "";

        for (char c = 'a'; c <= 'z'; c++) {
            string += c;
        }

        for (char c = 'A'; c <= 'Z'; c++) {
            string += c;
        }

        for (char c = '0'; c <= '9'; c++) {
            string += c;
        }

        do {
            String capcha = "";
            boolean haveLowerChar = false;
            boolean haveUpperChar = false;
            boolean haveDigit = false;
            //loop use to generate 5 charater into capcha
            for (int i = 0; i < 5; i++) {
                Random random = new Random();
                int index = random.nextInt(string.length());
                char newChar = string.charAt(index);
                //check newchar must be in range from character a to z
                if (newChar >= 'a' && newChar <= 'z') {
                    haveLowerChar = true;
                } else //check newchar must be in range from character A to Z
                    if (newChar >= 'A' && newChar <= 'Z') {
                    haveUpperChar = true;
                } else {
                    haveDigit = true;
                }
                capcha += newChar;
            }
            //check value of boolean variable haveDigit, haveLowerChar, and haveUpperChar
            if (haveDigit && haveLowerChar && haveUpperChar) {
                finalCapcha = capcha;
                break;
            } else {
            }
        } while (true);
        return finalCapcha;
    }

    void handleCapcha(String capcha, String capchaFail, String inputCapcha) {
        Validation v = new Validation();
        do {
            String newCapcha = createCapcha();
            System.out.println(capcha + newCapcha);
            String capchaInput = getCapcha(inputCapcha, capchaFail);
            if (newCapcha.equals(capchaInput)) {
                return;
            } else {
                System.out.println(capchaFail);
            }
        } while (true);
    }
    
    public String getCapcha(String msg, String errorMsg) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        System.out.print(msg);
        try {
            input = sc.nextLine();
            if (input.isEmpty()) {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.println(errorMsg);
        }

        return input;
    }
}
