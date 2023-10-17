/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0021_hoangvan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Hoangvan
 */
public class StudentList extends ArrayList<Student>{
    Scanner sc = new Scanner(System.in);
    
    Validation vali = new Validation();
   
    int cnt = 0;
    

    public boolean add(Student a) {
        cnt++;
       return super.add(a);
    }
  
    public int numbStu() {
        return cnt;
    }
    
    public boolean idExist(int id) {
        for(int i = 0; i < this.size(); i++) {
            if(this.get(i).getId() == id) {
                return true;
            }
        }
        return false;
    }
    
    public int getIndex(int id) {
        int index = -1;
        for(int i = 0; i < this.size(); i++) {
            if(this.get(i).getId() == id) {
                index =  i;
            }
    }
        return index;
    }
 
    
    public StudentList find(String name) {
        StudentList FoundList = new StudentList();
        for(int i = 0; i < this.numbStu(); i++) {
            if(this.get(i).getName().contains(name)) {
                FoundList.add(this.get(i));
            }
        }
        return FoundList;
    }
    
    public StudentList Sort(StudentList list) {
        Collections.sort(list, Comparator.comparing(Student::getName));
        return list;
    }
    
    public void update(Student upstu) {
        int index = getIndex(upstu.getId());
        this.set(index, upstu);
    }
    
    public void delete(int id) {
        this.remove(this.getIndex(id));
        cnt--;
    }
    
public void report() {
        for(int i = 0; i < this.numbStu(); i++) {
            System.out.println(this.get(i).getName() + "   " + this.get(i).getCourseNumber());
        }
    }

}
