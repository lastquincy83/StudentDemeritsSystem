import java.util.List;

/**
 * Created by Damian on 2017/02/18.
 */
public interface SchoolDBInterface
{
    public Users findUser(String userID);
    public void registerUser(Users users);
    public Boolean login(Users users, String password);
    public Boolean findStudent(String studentID);
    public void registerStudent(Students students);
    public void updateStudent(String userID,int demerits);
    public void deregisterStudent(String studentID);
    List<Schools> searchSchools(String searchText);
    List<Students> searchStudents(String searchText);
    public Boolean findSchool(String schoolID);
    public void registerSchool(Schools schools);
}
