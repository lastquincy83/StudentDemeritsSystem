import java.sql.Connection;

/**
 * Created by Damian on 2017/02/18.
 */
public class Students {
    private String studentID;
    private String studentName;
    private String studentSurname;
    private int demerits;
    private String schoolID;

    public Students(String studentID,String studentName, String studentSurname,int demerits, String schoolID) {
        this.studentID=studentID;
        this.studentName=studentName;
        this.studentSurname=studentSurname;
        this.demerits=demerits;
        this.schoolID=schoolID;
    }

    public void setSchoolID(String schoolID) {
        this.schoolID = schoolID;
    }

    public String getSchoolID() {
        return schoolID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getDemerits() {
        return demerits;
    }

    public void setDemerits(int demerits) {
        this.demerits = demerits;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    @Override
    public String toString() {
        return "Students{" +
                "studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentSurname='" + studentSurname + '\'' +
                ", demerits=" + demerits +
                ", schoolID='" + schoolID + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Students students = (Students) o;

        if (demerits != students.demerits) return false;
        if (!studentID.equals(students.studentID)) return false;
        if (studentName != null ? !studentName.equals(students.studentName) : students.studentName != null)
            return false;
        if (studentSurname != null ? !studentSurname.equals(students.studentSurname) : students.studentSurname != null)
            return false;
        return schoolID.equals(students.schoolID);
    }

    @Override
    public int hashCode() {
        int result = studentID.hashCode();
        result = 31 * result + (studentName != null ? studentName.hashCode() : 0);
        result = 31 * result + (studentSurname != null ? studentSurname.hashCode() : 0);
        result = 31 * result + demerits;
        result = 31 * result + schoolID.hashCode();
        return result;
    }
}
