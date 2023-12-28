package Student_File;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class StudentManager {
    private List<Student> students = new ArrayList<>();

    // Read student data from an input stream
    public void readStudentsFromStream(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 4) {
                    String studentId = parts[0];
                    String firstName = parts[1];
                    String lastName = parts[2];
                    double javaGrade = Double.parseDouble(parts[3]);
                    Student student = new Student(studentId, firstName, lastName, javaGrade);
                    students.add(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Calculate the average grade for each student
    public void calculateAverageGrades() {
        for (Student student : students) {
            // Perform the necessary calculations here
        }
    }

    // Save the list of students to an output stream with the average grade
    public void saveStudentsToStream(OutputStream outputStream) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
            for (Student student : students) {
                writer.write(student.toString()); // Write student details
                // Add the average grade to the end of the line (TB column)
                writer.write("\t" + calculateAverageGrade(student));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Calculate the average grade (you should implement this)
    private double calculateAverageGrade(Student student) {
        // Implement the calculation logic here
        // Example: return student.getJavaGrade(); // Assuming Java grade is the average
        return student.getJavaGrade(); // Replace with the actual calculation
    }

    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();

        // Load student data from an input stream (e.g., a file)
        InputStream inputStream = StudentManager.class.getResourceAsStream("student_grades.txt");
        studentManager.readStudentsFromStream(inputStream);

        // Example: Calculate and save the average grades
        studentManager.calculateAverageGrades();
        studentManager.saveStudentsToStream(System.out); // Save to console
    }
}
