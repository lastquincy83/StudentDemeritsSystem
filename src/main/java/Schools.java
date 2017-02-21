/**
 * Created by Damian on 2017/02/18.
 */
public class Schools {
    private String schoolID;
    private String schoolName;

    public Schools(String schoolID, String schoolName) {
        this.schoolID = schoolID;
        this.schoolName = schoolName;
    }

    public String getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(String schoolID) {
        this.schoolID = schoolID;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "Schools{" +
                "schoolID='" + schoolID + '\'' +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schools schools = (Schools) o;

        if (!schoolID.equals(schools.schoolID)) return false;
        return schoolName != null ? schoolName.equals(schools.schoolName) : schools.schoolName == null;
    }

    @Override
    public int hashCode() {
        int result = schoolID.hashCode();
        result = 31 * result + (schoolName != null ? schoolName.hashCode() : 0);
        return result;
    }
}
