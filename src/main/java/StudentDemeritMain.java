import com.student.datainterface.InMemorySchoolDB;
import com.student.datainterface.SchoolDBInterface;
import com.student.model.Users;
import com.student.service.Login;
import com.student.service.Register;
import com.student.userinterface.SchoolSelect;

import java.util.Scanner;

/**
 * Created by Damian on 2017/02/18.
 */
public class StudentDemeritMain {
    public static void main(String args[]){
//        SchoolDBInterface dataInterface = new InMemorySchoolDB();

        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("\tLogin Menu");
            System.out.println("==================");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0 to exit");
            String input  = sc.nextLine();
            switch (Integer.parseInt(input)) {
                case 1: {
                    System.out.println("Input user ID");
                    String userID = sc.nextLine();
                    System.out.println("Input Password");
                    String password = sc.nextLine();
                    Login userLogin = new Login();
                    if (userLogin.Login(userID,password)){
                        System.out.println("Login successful");
                    }else System.out.println("Login unsuccessful");
                    break;
                }
                case 2:{
                    System.out.println("Input user ID");
                    String userID = sc.nextLine();
                    System.out.println("Input Name");
                    String name = sc.nextLine();
                    System.out.println("Input Password");
                    String password = sc.nextLine();
                    Users users = new Users(userID,name,password);
                    Register register =new Register();
                    if (register.Register(users)){
                        System.out.println("Successfully registered user");
                    }else System.out.println("User already exists");
                    break;
                }
                case 0: System.exit(0);
            }
//            if (input.equals("0")){
//                System.exit(0);
//            } else if(input.equals("1")){
//                System.out.println("Input user ID");
//                String userID = sc.nextLine();
//                System.out.println("Input Password");
//                String password = sc.nextLine();
//                Users users = dataInterface.findUser(userID);
//                // obj.login(users,password);
//                if (users!=null){
//                    if(dataInterface.login(users,password)){
//                        SchoolSelect obj1 = new SchoolSelect();
//                        obj1.SchoolSelect();
//                    }else System.out.println("Incorrect password");
//                } else System.out.println("User does not exists");
//            } else if(input.equals("2")){
//                System.out.println("Input user ID");
//                String userID = sc.nextLine();
//                System.out.println("Input Name");
//                String name = sc.nextLine();
//                System.out.println("Input Password");
//                String password = sc.nextLine();
//                Users users = new Users(userID,name,password);
//                dataInterface.registerUser(users);
//            }
        }
    }
}
