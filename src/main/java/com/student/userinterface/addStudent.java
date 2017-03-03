package com.student.userinterface;

import com.student.datainterface.MYSQLSchoolDB;
import com.student.model.Students;

import java.util.Scanner;

/**
 * Created by Damian on 2017/02/21.
 */
public class addStudent {
    public void addStudent(){
        Scanner sc = new Scanner(System.in);
        MYSQLSchoolDB obj = new MYSQLSchoolDB();
        while (true){
            System.out.println("Enter Student ID");
            String studentID = sc.nextLine();
            if (obj.findStudent(studentID)){
                System.out.println("Enter student name");
                String studentName=sc.nextLine();
                System.out.println("Enter student surname");
                String studentSurname=sc.nextLine();
                System.out.println("Enter student demerits");
                int demerits =Integer.parseInt(sc.nextLine());
                System.out.println("Enter student school id");
                String schoolID=sc.nextLine();
                while (obj.findSchool(schoolID)){
                    System.out.println("School does not exist, re-enter existing school ID");
                    schoolID = sc.nextLine();
                }
                Students students = new Students(studentID,studentName,studentSurname,demerits,schoolID);
                obj.registerStudent(students);
                break;
            }else if(!obj.findStudent(studentID)){
                System.out.println("Student ID already exists");
            } else System.out.println("Incorrect input");
        }
    }
}
