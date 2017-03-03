package com.student.userinterface;

import com.student.datainterface.MYSQLSchoolDB;
import com.student.model.Schools;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Damian on 2017/02/19.
 */
public class SchoolSelect {

    public void SchoolSelect() {
        Scanner sc= new Scanner(System.in);
        MYSQLSchoolDB obj = new MYSQLSchoolDB();
        while(true){
            System.out.println("Enter School ID or 0 to exit");
            String searchText = sc.nextLine();
            if(searchText.equals("0")){
                break;
            }
            registerSchools obj1 = new registerSchools();
            List<Schools> search = obj.searchSchools(searchText);
            while (search.isEmpty()){
                System.out.println("School not found, register school Y/N");
                String input = sc.nextLine();
                if (input.equals("Y")||input.equals("y")){
                    obj1.registerSchools();
                    break;
                }else if (input.equals("N")||input.equals("n")){
                    break;
                }else System.out.println("Incorrect Input");
            }
            while (!search.isEmpty()){
                for (int i=0;i<search.size();i++){
                    Schools school = search.get(i);
                    System.out.println((i+1)+". "+school);
                }
                System.out.println("Select school or 0 to register new school");
                String num = sc.nextLine();
                if (num.equals("0")){
                    obj1.registerSchools();
                }else{
                    StudentMenu obj2 = new StudentMenu();
                    obj2.StudentMenu(num,search.size(),search);
                }
            }
        }

    }

}
