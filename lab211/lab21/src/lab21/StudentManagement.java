/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab21;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class StudentManagement {
    static Scanner sc = new Scanner(System.in);
    public void run(){
        while(true){
            System.out.println("WELCOME TO STUDENT MANAGEMENT");
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice){
                
            }
        }
    }
}
