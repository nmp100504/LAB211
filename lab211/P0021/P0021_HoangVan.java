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
public class P0021_HoangVan {
static Scanner sc = new Scanner(System.in);

   
    public static void main(String[] args) {
        StudentList stuli = new StudentList();
        Student stu = new Student();
        Validation vali = new Validation();
        // TODO code application logic here
        while(true) {
            System.out.println("WELCOME TO STUDENT MANAGEMENT\n" +
"   1. Create\n" +
"   2. Find and Sort\n" +
"   3. Update/Delete\n" +
"   4. Report\n" +
"   5. Exit\n"
                    + "Enter your choice");
            int n = Integer.parseInt(sc.nextLine());
            switch(n) {
                case 1:
                    while(stuli.numbStu() < 2) {
                        Student newstu = stu.createStudent(stuli);
                        stuli.add(newstu);
                    }
                    while(true) {
                        System.out.println("Add more or not? (Y/N)");
                        if(vali.inputYN()) {
                            Student newstu = stu.createStudent(stuli);
                            stuli.add(newstu);
                        }
                        else break;
                    }
                    break;
                case 2:
                    System.out.println("Enter name to find");
                    System.out.println(stuli.Sort(stuli.find(vali.inputString())));
                    break;
                case 3:
                    System.out.println("Update or delete? (U/D)");
                    if(vali.inputUD()) {
                        Student upstu = stu.upStu(stuli);
                        stuli.update(upstu);
                    }
                    else {
                        stuli.delete(stu.inputExID(stuli));
                    }
                    break;
                case 4:
                    stuli.report();
                    break;
                case 5:
                    return;
            }
        }
    }
    
}
