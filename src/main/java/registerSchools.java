import java.util.Scanner;

/**
 * Created by Damian on 2017/02/19.
 */
public class registerSchools {
    public void registerSchools(){
        Scanner sc = new Scanner(System.in);
        schoolsDBImpl obj = new schoolsDBImpl();
        System.out.println("Enter School ID");
        String schoolID=sc.nextLine();
        System.out.println("Enter School name");
        String schoolName = sc.nextLine();
        Boolean school1 = obj.findSchool(schoolID);
        if (school1){
            Schools school =new Schools(schoolID,schoolName);
            obj.registerSchool(school);
        }
        if (!school1){
            System.out.println("School ID already exists");
        }
    }
}
