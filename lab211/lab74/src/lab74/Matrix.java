/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab74;

/**
 *
 * @author Admin
 */
public class Matrix {

    int rows;
    int cols;
    int[][] element;

    public Matrix() {
    }

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        element = new int[rows][cols];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getValue(int row, int col) {
        return element[row][col];
    }

    public void setValue(int row, int col, int value) {
        element[row][col] = value;
    }

    void display() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                System.out.print(element[i][j] + " ");
            }
            System.out.println();
        }
    }

    Matrix add(Matrix m2) {

        int rowAns = getRows();
        int colAns = getCols();
        Matrix ans = new Matrix(rowAns, colAns);
        for (int i = 0; i < rowAns; i++) {
            for (int j = 0; j < colAns; j++) {
                ans.setValue(i, j, this.element[i][j] + m2.getValue(i, j));
            }
        }
        return ans;
    }

    Matrix subtract(Matrix m2) {
         int rowAns = getRows();
        int colAns = getCols();
        Matrix ans = new Matrix(rowAns, colAns);
        for (int i = 0; i < rowAns; i++) {
            for (int j = 0; j < colAns; j++) {
                ans.setValue(i, j, this.element[i][j] - m2.getValue(i, j));
            }
        }
        return ans;
    }

    Matrix multiply(Matrix m2) {

        int rowAns = this.getRows();
        int colAns = this.getCols();
        int col2 = m2.getCols();
        int row2 = m2.getRows();
        Matrix ans = new Matrix(rowAns, col2);
        for (int i = 0; i < rowAns; i++) {
            for (int j = 0; j < col2; j++) {
                int sum = 0;
                for (int k = 0; k < colAns; k++) {
                    sum += this.getValue(i, k) * m2.getValue(k, j);
                }
                ans.setValue(i, j, sum);
            }
        }
        return ans;
    }
}
