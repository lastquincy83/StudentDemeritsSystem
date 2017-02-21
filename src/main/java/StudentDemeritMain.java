import java.util.Scanner;

/**
 * Created by Damian on 2017/02/18.
 */
public class StudentDemeritMain {
    public static void main(String args[]){
        SchoolDBInterface obj = new schoolsDBImpl();

        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("\tLogin Menu");
            System.out.println("==================");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0 to exit");
            String input  = sc.nextLine();
            if (input.equals("0")){
                System.exit(0);
            } else if(input.equals("1")){
                System.out.println("Input user ID");
                String userID = sc.nextLine();
                System.out.println("Input Password");
                String password = sc.nextLine();
                Users users = obj.findUser(userID);
                // obj.login(users,password);
                if (users!=null){
                    if(obj.login(users,password)){
                        SchoolSelect obj1 = new SchoolSelect();
                        obj1.SchoolSelect();
                    }else System.out.println("Incorrect password");
                } else System.out.println("User does not exists");
            } else if(input.equals("2")){
                System.out.println("Input user ID");
                String userID = sc.nextLine();
                System.out.println("Input Name");
                String name = sc.nextLine();
                System.out.println("Input Password");
                String password = sc.nextLine();
                Users users = new Users(userID,name,password);
                obj.registerUser(users);
            }
        }
    }
}
