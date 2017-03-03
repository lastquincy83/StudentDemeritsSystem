package com.student.service;

import com.student.datainterface.InMemorySchoolDB;
import com.student.datainterface.MYSQLSchoolDB;
import com.student.datainterface.SchoolDBInterface;

/**
 * Created by Damian on 2017/02/23.
 */
public class Login {
    private SchoolDBInterface schoolDBInterface=new InMemorySchoolDB();
    public boolean Login(String userID, String password){
        if (schoolDBInterface.findUser(userID)!=null){
            if (schoolDBInterface.login(schoolDBInterface.findUser(userID),password)){
                return true;
            }else return false;
        }
        return false;
    }
}
