
import Student_Manager.*;

public class Main {
    public static void main(String[] args) {
        Student_Manager listStudent = new Student_Manager();

        listStudent.dataFromFile("grades.txt");

        listStudent.managementSys();

        listStudent.displayStudent();

        listStudent.dataOutFile("output.txt");


    }
}