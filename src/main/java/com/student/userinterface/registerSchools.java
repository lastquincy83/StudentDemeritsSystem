package com.student.userinterface;

import com.student.datainterface.MYSQLSchoolDB;
import com.student.model.Schools;

import java.util.Scanner;

/**
 * Created by Damian on 2017/02/19.
 */
public class registerSchools {
    public void registerSchools(){
        Scanner sc = new Scanner(System.in);
        MYSQLSchoolDB obj = new MYSQLSchoolDB();
        System.out.println("Enter School ID");
        String schoolID=sc.nextLine();
        System.out.println("Enter School name");
        String schoolName = sc.nextLine();
        Boolean school1 = obj.findSchool(schoolID);
        if (school1){
            Schools school =new Schools(schoolID,schoolName);
            obj.registerSchool(school);
        }
        if (!school1){
            System.out.println("School ID already exists");
        }
    }
}
