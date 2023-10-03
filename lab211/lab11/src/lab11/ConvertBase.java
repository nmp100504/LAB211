/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab11;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ConvertBase {

    private static Scanner sc = new Scanner(System.in);

    public static void run() {
        boolean continueee = true;
        do  {
            System.out.println("he co so ban dau: 1=bin 2=dec 3=hex");
            int inputBase = getUserChoice(sc);
            System.out.println("he co so chuyen toi: 1=bin 2=dec 3=hex");
            int outputBase = getUserChoice(sc);

            System.out.print("so can chuyen he: ");
            String value = numberInput(sc, inputBase);
                    
            System.out.println("so " + value + " chuyen toi he " + outputBase + " la: " + convertBase(value, inputBase, outputBase));
            System.out.println("tiep tuc ko? (y/n)");
            String continueChoice = sc.nextLine();
            if (continueChoice.equalsIgnoreCase("n")) {
                continueee = false;
            }
        }while(continueee==true);
    }

    public static String convertBase(String value, int inputBase, int outputBase) {
        BigInteger dec;
        switch (inputBase) {
            case 2:
                dec = new BigInteger(binToDec(value));
                break;
            case 10:
                dec = new BigInteger(value);
                break;
            case 16:
                dec = new BigInteger(hexToDec(value));
                break;
            default:
                return "khong hop le";
        }
        switch (outputBase) {
            case 2:
                return decToBin(dec);
            case 10:
                return dec.toString();
            case 16:
                return decToHex(dec);
            default:
                return "khong hop le";
        }
    }

    public static String decToBin(BigInteger dec) {
        if (dec.equals(BigInteger.ZERO)) {
            return "0";
        }
        StringBuilder binStr = new StringBuilder();
        while (!dec.equals(BigInteger.ZERO)) {
            int remain = dec.mod(BigInteger.valueOf(2)).intValue();
            binStr.insert(0, String.valueOf(remain));
            dec = dec.divide(BigInteger.valueOf(2));
        }
        return binStr.toString();
    }

    public static String decToHex(BigInteger dec) {
        if (dec.equals(BigInteger.ZERO)) {
            return "0";
        }
        StringBuilder hexStr = new StringBuilder();
        String hexDigits = "0123456789ABCDEF";
        while (!dec.equals(BigInteger.ZERO)) {
            int remain = dec.mod(BigInteger.valueOf(16)).intValue();
            hexStr.insert(0, hexDigits.charAt(remain));
            dec = dec.divide(BigInteger.valueOf(16));
        }
        return hexStr.toString();
    }

    public static String binToDec(String value) {
        BigInteger dec = BigInteger.ZERO;
        int binLength = value.length();
        for (int i = 0; i < binLength; i++) {
            char binNum = value.charAt(i);
            int digit = Character.getNumericValue(binNum);
            dec = dec.multiply(BigInteger.valueOf(2)).add(BigInteger.valueOf(digit));
        }
        return dec.toString();
    }

    public static String hexToDec(String value) {
        BigInteger dec = BigInteger.ZERO;
        int hexLength = value.length();
        for (int i = 0; i < hexLength; i++) {
            char binNum = value.charAt(i);
            int digit = Character.isDigit(binNum) ? binNum - '0' : Character.toUpperCase(binNum) - 'A' + 10;
            dec = dec.multiply(BigInteger.valueOf(16)).add(BigInteger.valueOf(digit));
        }
        return dec.toString();
    }

    public static String numberInput(Scanner sc, int inputBase) {
        String value;
        boolean valid = false;
        do {
            value = sc.nextLine();
            switch (inputBase) {
                case 2:
                    valid = isBin(value);
                    break;
                case 10:
                    valid = isDec(value);
                    break;
                case 16:
                    valid = isHex(value);
                    break;
                default:
                    System.out.println("sai he co so");
            }

        } while (!valid);
        return value;

    }

    public static boolean isBin(String s) {
        return s.matches("^[01]+$");
    }

    public static boolean isDec(String s) {
        return s.matches("^[0-9]+$");
    }

    public static boolean isHex(String s) {
        return s.matches("^[0-9A-F]+$");
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
