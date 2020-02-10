import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        var controller = new DataControler();
        var students = new ArrayList<Student>();
        String info = null;

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            showMenu();
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    students = controller.readStudentFromFile("hocvien.txt");

                    System.out.println("Mã học viên\t\t Họ tên\t\t\t Email \t\t\t\t Mark");
                    for (Student std :
                            students) {
                        System.out.println(std.getStudentID() + "\t" + std.getFullName() + "\t" + std.getEmail() + "\t" + "\t" + "\t" + std.getMark());
                    }
                    System.out.println();
                    break;
                case 2:
                    students = controller.readStudentFromFile("hocvien.txt");
                    for (Student std :
                            students) {
                        if (std.getStudentID().equals("CGMD001124")) {
                            System.out.println(std.toString());
                        }
                    }
                    System.out.println();
                    break;
                case 3:
                    students = controller.readStudentFromFile("hocvien.txt");
                    for (Student std :
                            students) {
                        if (std.getMark() > 85) {
                            System.out.println(std.getStudentID() + "\t" + std.getFullName() + "\t" + std.getMark());
                        }
                    }
                    System.out.println();
                    break;
                case 4:
                    students = controller.readStudentFromFile("hocvien.txt");
                    String regex = "^Nguyen.*";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher;

                    for (Student std :
                            students) {
                        matcher = pattern.matcher(std.getFullName());
                        if (matcher.find()) {
                            System.out.println(std.getStudentID() + "\t" + std.getFullName());
                        }
                    }
                    System.out.println();

                    break;
                case 5:
                    students = controller.readStudentFromFile("hocvien.txt");
                    String mailFormat = "^ [a-zA-Z]+[a-zA-Z0-9]*@{1}\\w+mail.com$";
                    Pattern patternMail = Pattern.compile(mailFormat);
                    Matcher matcherMail;

                    for (Student std :
                            students) {
                        matcherMail = patternMail.matcher(std.getEmail());
                        if (!matcherMail.find()) {
                            System.out.println(std.getStudentID() + "\t" + std.getFullName() + "\t" + std.getEmail());
                        }
                    }
                    System.out.println();
                    break;
                case 6:
                    students = controller.readStudentFromFile("hocvien.txt");
                    Collections.sort(students, new Comparator<Student>() {
                        @Override
                        public int compare(Student student1, Student student2) {
                            if (student1.getMark() < student2.getMark()) return 1;
                            return -1;
                        }
                    });

                    for (Student std :
                            students) {
                        System.out.println(std.getStudentID() + "\t" + std.getFullName() + "\t" + std.getEmail() + "\t" + std.getMark());
                    }
                    System.out.println();
                    break;
                case 7:
                    students = controller.readStudentFromFile("hocvien.txt");
                    Collections.sort(students, new Comparator<Student>() {
                        @Override
                        public int compare(Student student1, Student student2) {
                            if (student1.getMark() < student2.getMark()) return 1;
                            return -1;
                        }
                    });

                    for (Student std :
                            students) {
                        System.out.println(std.getStudentID() + "\t" + std.getFullName() + "\t" + std.getEmail() + "\t" + std.getMark());
                        controller.writeToFile(std, "sapxepdiem.txt");
                    }
                    System.out.println();

                    break;
                case 8:
                    students = controller.readStudentFromFile("hocvien.txt");

                    List<String> firstName=new ArrayList<>();
                    List<String> familyName=new ArrayList<>();

                    

                    Collections.sort(students, new Comparator<Student>() {
                        @Override
                        public int compare(Student student1, Student student2) {
                            if (student1.getMark() < student2.getMark()) return 1;
                            return -1;
                        }
                    });

                    break;
                case 9:
                    break;
                case 10:
                    students = controller.readStudentFromFile("hocvien.txt");

                    String stdID, stdFullName, stdEmail;
                    int stdMark;

                    System.out.println("Input student ID: ");
                    stdID = scanner.nextLine();

                    System.out.println("Input student full name: ");
                    stdFullName = scanner.nextLine();

                    System.out.println("Input student email: ");
                    stdEmail = scanner.nextLine();

                    System.out.println("Input student mark: ");
                    stdMark = Integer.parseInt(scanner.nextLine());

                    students.add(new Student(stdID, stdFullName, stdEmail, stdMark));

                    for (Student std :
                            students) {
                        System.out.println(std.toString());
                    }
                    break;
                case 11:

                    System.out.println("Input ID you want to edit: ");
                    String wantEditID = scanner.nextLine();

                    students = controller.readStudentFromFile("hocvien.txt");
                    for (Student std :
                            students) {
                       if (std.getStudentID().equalsIgnoreCase(wantEditID)){
                           System.out.println("Input student full name: ");
                           std.setFullName(scanner.nextLine());

                           System.out.println("Input student email: ");
                          std.setEmail(scanner.nextLine());

                           System.out.println("Input student mark: ");
                           std.setMark(Integer.parseInt(scanner.nextLine()));

                           break;
                       }
                    }
                    for (Student std :
                            students) {
                        System.out.println(std.toString());
                    }
                    break;
                case 12:
                    System.out.println("Input ID you want to delete: ");
                    String wantDeleteID = scanner.nextLine();

                    students = controller.readStudentFromFile("hocvien.txt");
                    for (Student std :
                            students) {
                        if (std.getStudentID().equalsIgnoreCase(wantDeleteID)){
                            students.remove(std);
                            break;
                        }
                    }
                    for (Student std :
                            students) {
                        System.out.println(std.toString());
                    }
                    break;
                case 13:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Please re-input!");
                    break;
            }
        } while (choice != 13);

    }

    private static void showStudentInfo(ArrayList<Student> students) {
        for (var student :
                students) {
            System.out.println(student);
        }
    }

    static void showMenu() {
        System.out.println("----------MENU----------");
        System.out.println("1. Show info from file hocvien.txt.txt");
        System.out.println(("2. Show info of student with ID CGMD001124"));
        System.out.println("3. Show list of student with mark > 85");
        System.out.println("4. Show list of Nguyen family student");
        System.out.println("5. Displays a list of students with a malformed email");
        System.out.println("6. Sort students according to the descending test scores");
        System.out.println("7. Output student list to sapxepdiem.txt");
        System.out.println("8. Sort student list by ascending name, if overlapping names sort by last name");
        System.out.println("9. Output student list to sapxephoten.txt");
        System.out.println("10. Add student");
        System.out.println("11. Edit student");
        System.out.println("12. Delete student");
        System.out.println("13. Exit");
        System.out.println("Your choice is: ");
    }
}
