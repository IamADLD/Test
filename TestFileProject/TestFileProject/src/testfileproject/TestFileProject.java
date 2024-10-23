/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfileproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aswaisi
 */
public class TestFileProject {

    /**
     * @param args the command line arguments
     */
    static ArrayList<User> myList = new ArrayList<>();

    public static void main(String[] args) {
        // TODO code application logic here
        /*
        myList.sort((o1, o2) -> {
            return o1.getName().compareTo(o2.getName()); //To change body of generated lambdas, choose Tools | Templates.
        });
        myList.sort((o1, o2) -> {
            return o2.getName().compareTo(o1.getName()); //To change body of generated lambdas, choose Tools | Templates.
        });*/
        ///////////////////////////////////////////////////
        readDataFromFile();
        Scanner s = new Scanner(System.in);
        boolean isRun = true;
        while (isRun) {
            System.out.println("*************************************************");
            System.out.println("1- Add New Student.");
            System.out.println("2- Show All Student.");
            System.out.println("3- Exit.");
            
            int select = s.nextInt();
            switch (select) {
                case 1:
                    System.out.println("Enter ID: ");
                    int id = s.nextInt();
                    System.out.println("Enter Name: ");
                    s.nextLine();
                    String name = s.nextLine();
                    System.out.println("Enter GPA: ");
                    double gpa = s.nextDouble();
                    Student stu = new Student(id, name, gpa);
                    myList.add(stu);
                    saveDateInFile();
                    break;
                case 2:
                    for (int i = 0; i < myList.size(); i++) {
                        System.out.println(myList.get(i).toString());
                    }
                    break;
                case 3:
                    isRun = false;
                    System.out.println("Done");
                    break;
                default:
                    System.out.println("Error Select input...");
            }
        }
    }

    static File f = new File("userInfo.data");
    public static void saveDateInFile() {
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(myList);
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not Found" + ex);
        } catch (IOException ioe) {
            System.out.println("Error write Data" + ioe);
        }
    }
    
    public static void readDataFromFile(){
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            myList = (ArrayList<User>)ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found..."+ex);
        } catch (IOException ioe) {
            System.out.println("Error read data..."+ioe);
        } catch (ClassNotFoundException cnf) {
            System.out.println("Class user not found..."+cnf);
        }
    }

}
