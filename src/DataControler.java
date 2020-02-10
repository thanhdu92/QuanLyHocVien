import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class DataControler {
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;
    private Scanner scanner;

    public void openFileToRead(String fileName) {
        try {
            scanner = new Scanner(Paths.get(fileName), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void closeFileAfterRead(String fileName) {
        try {
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openFileToWrite(String fileName) {
        try {
            fileWriter = new FileWriter(fileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(Student student, String fileName) {
        openFileToWrite(fileName);
        printWriter.println(student.getStudentID() + ";"
                + student.getFullName() + ";"
                + student.getEmail() + ";"
                + student.getMark());
        closeFileAfterWrite(fileName);
    }

    public void closeFileAfterWrite(String fileName) {
        try {
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Student> readStudentFromFile(String fileName) {
        openFileToRead(fileName);
        ArrayList<Student> students = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            Student student = createStudentFromData(data);
            students.add(student);
        }

        closeFileAfterRead(fileName);
        return students;
    }

    public Student createStudentFromData(String data) {
        String[] datas = data.split(";");

        Student student = new Student(datas[0],datas[1],datas[2],Integer.parseInt(datas[3]));
        return student;
    }
}
