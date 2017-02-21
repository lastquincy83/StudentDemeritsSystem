import java.util.Scanner;

/**
 * Created by Damian on 2017/02/21.
 */
public class removeStudent {
    public void removeStudent(){
        Scanner sc = new Scanner(System.in);
        schoolsDBImpl obj = new schoolsDBImpl();
        System.out.println("Enter Student ID to delete");
        String studentID = sc.nextLine();
        if(obj.findStudent(studentID)){
            obj.deregisterStudent(studentID);
        }
        else if (!obj.findStudent(studentID)){
            System.out.println("Student ID does not exits");
        }
    }
}
