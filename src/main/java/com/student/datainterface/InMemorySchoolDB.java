package com.student.datainterface;

import com.student.model.Schools;
import com.student.model.Students;
import com.student.model.Users;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Damian on 2017/02/23.
 */
public class InMemorySchoolDB implements SchoolDBInterface {
    static List<Users> userss = new ArrayList<Users>();
    public Users findUser(String userID) {
        for (int i=0;i<userss.size();i++){
            Users users=userss.get(i);
            String UserID = users.getUserID();
            if(UserID.equals(userID)){
                return users;
            }
        }
        return null;
    }

    public void registerUser(Users users) {
        if (findUser(users.getUserID())==null){
            userss.add(users);
        } else System.out.println("User ID already exists");
    }

    public Boolean login(Users users, String password) {
        if(users.getPassword().equals(password)){
            return true;
        }else return false;
    }

    public Boolean findStudent(String studentID) {
        return null;
    }

    public void registerStudent(Students students) {

    }

    public void updateStudent(String userID, int demerits) {

    }

    public void deregisterStudent(String studentID) {

    }

    public List<Schools> searchSchools(String searchText) {
        return null;
    }

    public List<Students> searchStudents(String searchText) {
        return null;
    }

    public Boolean findSchool(String schoolID) {
        return null;
    }

    public void registerSchool(Schools schools) {

    }
}
