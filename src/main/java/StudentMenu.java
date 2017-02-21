import java.util.List;
import java.util.Scanner;

/**
 * Created by Damian on 2017/02/19.
 */
public class StudentMenu {
    public void StudentMenu(String input, int size, List<Schools> list){
        Schools schools= list.get(Integer.parseInt(input)-1);
        Scanner sc= new Scanner(System.in);
        System.out.println(schools);
        while (true){
            System.out.println("Would you like to ");
            System.out.println("1. register student");
            System.out.println("2. update student");
            System.out.println("3. delete student");
            System.out.println("0. exit");
            String choice=sc.nextLine();
            int choice1 =Integer.parseInt(choice);
            switch (choice1){
                case 1:{
                    addStudent obj = new addStudent();
                    obj.addStudent();
                    break;
                }
                case 2:{
                    updateStudent obj = new updateStudent();
                    obj.updateStudent();
                    break;
                }
                case 3:{
                    removeStudent obj = new removeStudent();
                    obj.removeStudent();
                    break;
                }
                case 0: System.exit(0);
            }
        }

    }
}
