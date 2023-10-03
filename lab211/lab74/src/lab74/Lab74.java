/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab74;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Lab74 {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO code application logic here
        while (true) {
            System.out.println("Matrix calculator: ");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Exit");

            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter 1st matrix: ");
                    Matrix m1 = inputMatrix();
                    System.out.println("Enter 2nd matrix: ");
                    Matrix m2 = inputMatrix();
                    System.out.println("Add result: ");
                    if(m1.getCols()!=m2.getCols() || m1.getRows()!=m2.getRows()){
                        System.out.println("Not suit data, can not add.");
                        break;
                    }
                    m1.add(m2).display();
                    break;
                case 2:
                    System.out.println("Enter 1st matrix: ");
                    Matrix m11 = inputMatrix();
                    System.out.println("Enter 2nd matrix: ");
                    Matrix m22 = inputMatrix();
                    System.out.println("Subtract result: ");
                    if(m11.getCols()!=m22.getCols() || m11.getRows()!=m22.getRows()){
                        System.out.println("Not suit data, can not add.");
                        break;
                    }
                    m11.subtract(m22).display();
                    break;
                case 3:
                    System.out.println("Enter 1st matrix: ");
                    Matrix m111 = inputMatrix();
                    System.out.println("Enter 2nd matrix: ");
                    Matrix m222 = inputMatrix();
                    System.out.println("Multiply result: ");
                    m111.multiply(m222).display();
                    break;
                case 4:
                    System.out.println("Exit...");
                    System.exit(0);
                default:
                    System.out.println("Not an option!");
            }
        }
    }

    public static Matrix inputMatrix() {

        int rows, cols;
        do {
            System.out.print("Rows: ");
            rows = sc.nextInt();
            sc.nextLine();
        } while (!isPositiveNum(String.valueOf(rows)));

        do {
            System.out.print("Cols: ");
            cols = sc.nextInt();
            sc.nextLine();
        } while (!isPositiveNum(String.valueOf(cols)));
        Matrix m = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Element["+i+"]["+j+"]: ");
                m.setValue(i, j, Integer.parseInt(inputMatrixElement()));
            }
        }
        return m;

    }

    static String inputMatrixElement() throws NumberFormatException {
        String valueInput = sc.nextLine();

        while (!isNumber(valueInput)) {
            System.out.println("Values of matrix must be the number");
            valueInput = sc.nextLine();
            if (isNumber(valueInput)) {
                return valueInput;
            }
        }
        return valueInput;
    }

    static boolean isPositiveNum(String input) {
        return (input.matches("^[0-9]+$") && Integer.parseInt(input) > 0);
    }

    static boolean isNumber(String input) {
        if (!Character.isDigit(input.charAt(0)) && input.charAt(0) != '-') {
            return false;
        }
        for (int i = 1; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
