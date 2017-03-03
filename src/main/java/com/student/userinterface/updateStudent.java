package com.student.userinterface;

import com.student.datainterface.MYSQLSchoolDB;
import com.student.model.Students;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Damian on 2017/02/21.
 */
public class updateStudent {
    public void updateStudent(){
        Scanner sc = new Scanner(System.in);
        MYSQLSchoolDB obj = new MYSQLSchoolDB();
        System.out.println("Enter student ID");
        String studentID=sc.nextLine();
        if (obj.findStudent(studentID)){
            System.out.println("1. increase demerits");
            System.out.println("2. decrease demerits");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:{
                    List<Students>student=obj.searchStudents(studentID);
                    Students students=null;
                    for (int i=0;i<student.size();i++){
                         students= student.get(i);
                    }
                    int demerits = students.getDemerits();
                    System.out.println("Enter demerit increment");
                    int increment = Integer.parseInt(sc.nextLine());
                    obj.updateStudent(studentID,increment+demerits);
                    break;
                }
                case 2:{
                    List<Students>student=obj.searchStudents(studentID);
                    Students students=null;
                    for (int i=0;i<student.size();i++){
                        students= student.get(i);
                    }
                    int demerits = students.getDemerits();
                    System.out.println("Enter demerit increment");
                    int increment = Integer.parseInt(sc.nextLine());
                    obj.updateStudent(studentID,demerits-increment);
                    break;
                }
                default:System.out.println("incorrect input");
                break;
            }
            System.out.println("Enter demerit increment");
        }else if(!obj.findStudent(studentID)){
            System.out.println("Student ID does not exist");
        }

    }
}
