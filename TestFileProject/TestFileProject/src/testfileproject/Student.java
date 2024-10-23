/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfileproject;

/**
 *
 * @author aswaisi
 */
public class Student extends User {
    
    private double GPA;

    public Student(int id, String name, double GPA) {
        super(id, name);
        this.GPA = GPA;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return super.toString() + "Student{" + "GPA=" + GPA + '}';
    }
    
    
    
}
