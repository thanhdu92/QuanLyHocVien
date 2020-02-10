import java.util.Scanner;

public class Student {
    private String studentID;
    private String fullName;
    private String email;
    private int mark;

    Scanner scanner=new Scanner(System.in);

    public Student() {
    }

    public Student(String studentID, String fullName, String email, int mark) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.email = email;
        this.mark = mark;
    }

    public void edit(){
        String stdID, stdFullName, stdEmail;
        int stdMark;

        System.out.println("Input student full name: ");
        stdFullName = scanner.nextLine();

        System.out.println("Input student email: ");
        stdEmail = scanner.nextLine();

        System.out.println("Input student mark: ");
        stdMark = Integer.parseInt(scanner.nextLine());
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
