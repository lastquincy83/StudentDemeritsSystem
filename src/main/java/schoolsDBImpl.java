import com.sun.org.apache.xerces.internal.impl.xs.SchemaGrammar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


/**
 * Created by Damian on 2017/02/18.
 */
public class schoolsDBImpl implements SchoolDBInterface{
    static final String DB_URL = "jdbc:mysql://localhost:3311/StudentDemeritsSystem";
    static final String USER = "root";
    static final String PASS = "root";

    public Connection getDBConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Successfully connected to DB");
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Users findUser(String userID) {
        Statement stmt = null;
        Connection dbConnection = getDBConnection();
        try {

            stmt = dbConnection.createStatement();
            String sql = "SELECT DISTINCT UserID,UserName,PASSWORD FROM users WHERE UserID = '"+userID+"';";
            ResultSet rs=stmt.executeQuery(sql);
            Users user =null;
            while (rs.next()){
                String userId = rs.getString("UserID");
                String userName = rs.getString("UserName");
                String password = rs.getString("password");
                user = new Users(userId,userName,password);
            }
            return user;
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if (stmt!=null){
                    stmt.close();
                }
                if (dbConnection!=null){
                    dbConnection.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }

        public void registerUser(Users users) {
            Statement stmt = null;
            Connection dbConnection = getDBConnection();
            try{
                stmt = dbConnection.createStatement();
                String userID = users.getUserID();
                String userName = users.getUserName();
                String password = users.getPassword();
                if (findUser(userID)==null) {
                    String sql = "INSERT INTO users (UserID,UserName,PASSWORD) VALUES ('" + userID + "','" + userName + "','" + password + "');";
                    stmt.execute(sql);
                } else{
                    System.out.println("User ID already exists");
                }

            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try {
                    if (stmt!=null){
                        stmt.close();
                    }
                    if (dbConnection!=null){
                        dbConnection.close();
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

        public Boolean login(Users users,String password) {
            if (users.getUserID()==null){
                return false;
            }
            if(users.getPassword().equals(password)){
                return true;
            }
            return false;
        }

        public Boolean findStudent(String studentID) {
            Statement stmt = null;
            Connection dbConnection = getDBConnection();
            try {
                stmt = dbConnection.createStatement();
                String sql ="SELECT ALL StudentID FROM students WHERE StudentID = '"+studentID+"';";
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()){
                    return false;
                }else return true;
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try {
                    if (stmt!=null){
                        stmt.close();
                    }
                    if (dbConnection!=null){
                        dbConnection.close();
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

        return null;
        }

        public void registerStudent(Students students) {
            Statement stmt = null;
            Connection dbConnection = getDBConnection();
            try{
                stmt = dbConnection.createStatement();
                String sql = "INSERT INTO students (StudentID,StudentName,StudentSurname,Demerits,SchoolID) VALUES ('"
                        +students.getStudentID()+"','"
                        +students.getStudentName()+"','"
                        +students.getStudentSurname()+"','"
                        +students.getDemerits()+"','"
                        +students.getSchoolID()+"');";
                stmt.execute(sql);
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try {
                    if (stmt!=null){
                        stmt.close();
                    }
                    if (dbConnection!=null){
                        dbConnection.close();
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

        public void updateStudent(String studentID,int demerits) {
            Statement stmt = null;
            Connection dbConnection = getDBConnection();
            try{
                stmt = dbConnection.createStatement();
                String sql = "UPDATE students SET Demerits = "+demerits+" WHERE userID = '"+studentID+"';";
                stmt.executeUpdate(sql);
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try {
                    if (stmt!=null){
                        stmt.close();
                    }
                    if (dbConnection!=null){
                        dbConnection.close();
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

        public void deregisterStudent(String studentID) {
            Statement stmt = null;
            Connection dbConnection = getDBConnection();
            try{
                stmt = getDBConnection().createStatement();
                String sql = "DELETE FROM students WHERE StudentID = '"+studentID+"';";
                stmt.execute(sql);
                System.out.println("Student removed from DB");
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try {
                    if (stmt!=null){
                        stmt.close();
                    }
                    if (dbConnection!=null){
                        dbConnection.close();
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

        }

        public List<Schools> searchSchools(String searchText) {
            List<Schools> results=new ArrayList<Schools>();
            Statement stmt=null;
            Connection dbConnection = getDBConnection();
            try{
                stmt= dbConnection.createStatement();
                String sql = "SELECT ALL SchoolID, SchoolName FROM schools WHERE SchoolID LIKE '"+searchText+"' OR SchoolName LIKE '"+searchText+"';";
                ResultSet rs =stmt.executeQuery(sql);
                while (rs.next()){
                    String schoolID=rs.getString("SchoolID");
                    String schoolName = rs.getString("SchoolName");
                    Schools school = new Schools(schoolID,schoolName);
                    results.add(school);
                }
                if(rs==null){
                    return null;
                }else return results;
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try {
                    if (stmt!=null){
                        stmt.close();
                    }
                    if (dbConnection!=null){
                        dbConnection.close();
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            return null;
        }

        public List<Students> searchStudents(String searchText) {
            List<Students> results=new ArrayList<Students>();
            Statement stmt=null;
            Connection dbConnection = getDBConnection();
            try{
                stmt= dbConnection.createStatement();
                String sql = "SELECT ALL StudentID,StudentName,StudentSurname,SchoolID,Demerits FROM schools WHERE StudentID LIKE '"+searchText+"' OR StudentName LIKE '"+searchText+"' OR StudentSurname LIKE '"+searchText+"' ORDER BY Demerits DESC;";
                ResultSet rs =stmt.executeQuery(sql);
                while (rs.next()){
                    String studentID=rs.getString("StudentID");
                    String studentName = rs.getString("StudentName");
                    String studentSurname = rs.getString("StudentSurname");
                    String schoolID = rs.getString("SchoolID");
                    int demerits = rs.getInt("Demerits");
                    Students students = new Students(studentID,studentName,studentSurname,demerits,schoolID);
                    results.add(students);
                }
                if(rs==null){
                    return null;
                }else return results;
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try {
                    if (stmt!=null){
                        stmt.close();
                    }
                    if (dbConnection!=null){
                        dbConnection.close();
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        return null;
        }

        public void registerSchool(Schools schools) {
            Statement stmt = null;
            Connection dbConnection = getDBConnection();
            String schoolID =schools.getSchoolID();
            String schoolName = schools.getSchoolName();
            try {
                stmt = dbConnection.createStatement();
                String sql = "INSERT INTO schools (SchoolID,SchoolName) VALUES ('"+schoolID+"','"+schoolName+"');";
                stmt.execute(sql);
                System.out.println("Successfully added school");
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try {
                    if (stmt!=null){
                        stmt.close();
                    }
                    if (dbConnection!=null){
                        dbConnection.close();
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

    public Boolean findSchool(String schoolID) {
        Statement stmt = null;
        Connection dbConnection = getDBConnection();
        try {
            stmt = dbConnection.createStatement();
            String sql ="SELECT ALL SchoolID FROM schools WHERE SchoolID = '"+schoolID+"';";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()){
                return false;
            }else return true;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if (stmt!=null){
                    stmt.close();
                }
                if (dbConnection!=null){
                    dbConnection.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }
}

