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
public class Number11 {

    String value;
    int base;

    public Number11() {
    }

    public Number11(String value, int base) {
        this.value = value;
        this.base = base;
    }

    public String getValue() {
        return value;
    }

    public String convertBase(int outputBase) {
        BigInteger dec;
        switch (base) {
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

    public static boolean isBin(String s) {
        return s.matches("^[01]+$");
    }

    public static boolean isDec(String s) {
        return s.matches("^[0-9]+$");
    }

    public static boolean isHex(String s) {
        return s.matches("^[0-9A-F]+$");
    }

    private  String decToBin(BigInteger dec) {
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

    private  String decToHex(BigInteger dec) {
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

    public void setValue(String value) throws Exception {
        boolean valid = false;

        switch (this.base) {
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
                throw new IllegalArgumentException("Invalid base: " + this.base);
        }

        if (!valid) {
            throw new IllegalArgumentException("Invalid value for base " + this.base + ": " + value);
        }

        this.value = value;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

}
