/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab21;

/**
 *
 * @author Admin
 */
public class Student {

    int id;
    String nameString;
    int semester;
    String course;

    public Student() {
    }

    public Student(int id, String nameString, int semester, String course) {
        this.id = id;
        this.nameString = nameString;
        this.semester = semester;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameString() {
        return nameString;
    }

    public void setNameString(String nameString) {
        this.nameString = nameString;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "id=" + id + ", nameString=" + nameString + ", semester=" + semester + ", course=" + course;
    }

}
