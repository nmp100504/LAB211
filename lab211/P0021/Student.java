
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0021_hoangvan;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hoangvan
 */
public class Student {
    Scanner sc = new Scanner(System.in);
    Validation vali = new Validation();
    
    private int id;
    private String name;
    private int semester;
    private String courseName;
    private int courseNumber = 1;

    public Student() {
    }

    public Student(int id, String name, int semester, String courseName) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSemester() {
        return semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }
    
    public String toString() {
        return id + "   " + name + "   " + semester + "   " + courseName + "   " + courseNumber;
    }
    
    public int inputNewID(ArrayList<Student> list) {
        System.out.println("Enter id");
        while(true) {
            int id = vali.inputInt();
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).getId() == id) {
                    System.out.println("Existed, re-input");
                    continue;
                }
                return id;
            }
        }
    }
    
    public int inputExID(ArrayList<Student> list) {
        System.out.println("Enter id: ");
        while(true) {
            int id = vali.inputInt();
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).getId() != id) {
                    continue;
                }
                else break;
            }
             return id;
        }
    }
    
    public Student createStudent(ArrayList<Student> list) {
        Student stu = new Student();
        stu.setId(inputNewID(list));
        System.out.println("Enter name: ");
        stu.setName(vali.inputString());
        System.out.println("Enter semester: ");
        stu.setSemester(vali.inputInt());
        System.out.println("Enter course name: ");
        stu.setCourseName(vali.inputCourseName());
        return stu;
    }
    
    public Student upStu(ArrayList<Student> list) {
         Student stu = new Student();
        stu.setId(inputExID(list));
        System.out.println("Enter name: ");
        stu.setName(vali.inputString());
        System.out.println("Enter semester: ");
        stu.setSemester(vali.inputInt());
        System.out.println("Enter course name: ");
        stu.setCourseName(vali.inputCourseName());
        return stu;
    }

}


