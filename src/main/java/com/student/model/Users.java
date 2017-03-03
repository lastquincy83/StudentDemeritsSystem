package com.student.model;

/**
 * Created by Damian on 2017/02/18.
 */
public class Users {
    private String userID;
    private String userName;
    private String password;

    public Users(String userID, String userName, String password) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (!userID.equals(users.userID)) return false;
        if (!userName.equals(users.userName)) return false;
        return password.equals(users.password);
    }

    @Override
    public int hashCode() {
        int result = userID.hashCode();
        result = 31 * result + userName.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}
