package com.student.service;

import com.student.datainterface.InMemorySchoolDB;
import com.student.datainterface.MYSQLSchoolDB;
import com.student.datainterface.SchoolDBInterface;
import com.student.model.Users;

/**
 * Created by Damian on 2017/02/23.
 */
public class Register {
    private SchoolDBInterface schoolDBInterface =new InMemorySchoolDB();
    public boolean Register(Users users){
        if(schoolDBInterface.findUser(users.getUserID())==null){
            schoolDBInterface.registerUser(users);
            return true;
        }else  return false;
    }
}
