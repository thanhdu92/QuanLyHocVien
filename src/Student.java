public class Student {
    private String studentID;
    private String fullName;
    private String email;
    private int mark;

    public Student() {
    }

    public Student(String studentID, String fullName, String email, int mark) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.email = email;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", mark=" + mark +
                '}';
    }


    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
