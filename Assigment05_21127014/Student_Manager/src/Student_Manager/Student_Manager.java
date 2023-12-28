package Student_Manager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student_Manager {
    List<Student> listStudent = new ArrayList<>();

    public void displayStudent() {
        for (Student i : listStudent) {
            System.out.println(i);
        }
    }

    public void dataFromFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String str;
            while (true) {
                str = br.readLine();
                if (str == null) {
                    break;
                }

                String[] stud = str.split("\\t");
                Student tmp = new Student(stud[0], stud[1], stud[2], Double.parseDouble(stud[3]), Double.parseDouble(stud[4]), Double.parseDouble(stud[5]));
                listStudent.add(tmp);
            }
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }

    public void dataOutFile(String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write("Name"+"\t"+ "ID\tPhone\tProject\tMidterm\tFinal\tGPA\n");
            for (Student i : listStudent) {
                bw.write(String.valueOf(i));
                bw.write("\t" + (i.getMid() + i.getFinal() + i.getProject())/3);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error " + e);
        }
    }

    public void addScore() {
        Scanner tmp = new Scanner(System.in);
        System.out.println("ADD GRADE");
        System.out.print("Enter Student Name to add score: ");
        String name = "";

        if (tmp.hasNextLine()) {
            name = tmp.nextLine();
        } else {
            // Handle the case when no input is provided
            System.out.println("Invalid input. Please enter a valid student name.");
            return;
        }
        System.out.println(name);

        for (Student i : listStudent){
            if (i.getName().equals(name)){
                System.out.println("1. Project Score");
                System.out.println("2. Midterm Score");
                System.out.println("3. Final Score");
                System.out.print("Enter your option : ");
                String opt = tmp.next();
                System.out.print("Enter score : ");
                double score = tmp.nextDouble();
                switch (opt){
                    case "1": {
                        i.setProjectScore(score);
                        System.out.println("SUCCESSFULL");
                        break;
                    }
                    case "2": {
                        i.setMidScore(score);
                        System.out.println("SUCCESSFULL");
                        break;
                    }
                    case "3": {
                        i.setFinalScore(score);
                        System.out.println("SUCCESSFULL");
                        break;
                    }
                }
            }
        }
    }

    public void modifyScore(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("MODIFY GRADE");
        System.out.print("Enter Student Name to modify score : ");
        String name = scanner.nextLine();
        System.out.println(name);
        for (Student i : listStudent){
            if (i.getName().equals(name)){
                System.out.println("1. Project Score");
                System.out.println("2. Midterm Score");
                System.out.println("3. Final Score");
                System.out.print("Enter your option : ");
                String opt = scanner.next();
                System.out.print("Enter score : ");
                double score = scanner.nextDouble();
                switch (opt){
                    case "1": {
                        i.setProjectScore(score);
                        break;
                    }
                    case "2": {
                        i.setMidScore(score);
                        break;
                    }
                    case "3": {
                        i.setFinalScore(score);
                        break;
                    }
                }
            }
        }
    }

    public void managerScore(){
        System.out.println("MANAGER SCORE");
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add Grade");
        System.out.println("2. Modify Grade");
        System.out.println("Enter your option : ");
        String opt = scanner.next();

        switch (opt) {
            case "1": {
                addScore();
                break;
            }
            case "2": {
                modifyScore();
                break;
            }
        }
    }

    public void managerStudent() {
        System.out.println("MANAGER STUDENT");
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add Grade");
        System.out.println("2. Modify Grade");
        System.out.println("Enter your option : ");
        String opt = scanner.next();
        switch (opt) {
            case "1": {
                addStudent();
                System.out.println("SUCCESSFULL");
                break;
            }
            case "2": {
                modifyStudent();
                System.out.println("SUCCESSFULL");
                break;
            }
        }
    }

    public void addStudent() {
        System.out.println("ADD STUDENT");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name : ");
        String name = scanner.nextLine();
        System.out.println("Enter ID : ");
        String id = scanner.nextLine();
        System.out.println("Enter Phone Number : ");
        String phone = scanner.nextLine();
        System.out.println("Enter Project Score : ");
        Double project = scanner.nextDouble();
        System.out.println("Enter Midterm Score : ");
        Double midterm = scanner.nextDouble();
        System.out.println("Enter Final Score : ");
        Double finalScore = scanner.nextDouble();
        Student tmp = new Student(name, id, phone, project, midterm, finalScore);
        listStudent.add(tmp);
    }

    public void modifyStudent() {
        System.out.println("MODIFY STUDENT");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student's name to modify : ");
        String name = scanner.nextLine();
        for (Student i : listStudent ){
            if (i.getName().equals(name)){
                System.out.println("1. Modify Name");
                System.out.println("2. Modify ID");
                System.out.println("3. Modify Phone Number");
                System.out.println("4. Modify Project Score");
                System.out.println("5. Modify Midterm Score");
                System.out.println("6. Modify Final Score");
                System.out.print("Enter option to modify : ");
                String opt = scanner.next();
                switch (opt) {
                    case "1": {
                        System.out.println("Enter Name : ");
                        String newname = scanner.nextLine();
                        i.setName(newname);
                        break;
                    }

                    case "2": {
                        System.out.println("Enter ID : ");
                        String newname = scanner.nextLine();
                        i.setID(newname);
                        break;
                    }

                    case "3": {
                        System.out.println("Enter Phone Number : ");
                        String newname = scanner.nextLine();
                        i.setPhoneNumber(newname);
                        break;
                    }

                    case "4": {
                        System.out.println("Enter Project Score : ");
                        Double newname = scanner.nextDouble();
                        i.setProjectScore(newname);
                        break;
                    }

                    case "5": {
                        System.out.println("Enter Midterm Score : ");
                        Double newname = scanner.nextDouble();
                        i.setMidScore(newname);
                        break;
                    }

                    case "6": {
                        System.out.println("Enter Final Score : ");
                        Double newname = scanner.nextDouble();
                        i.setFinalScore(newname);
                        break;
                    }
                }
            }
        }
    }


    public void managementSys(){
        System.out.println("Management System");
        System.out.println("1. Manage Score");
        System.out.println("2. Manage Student");
        System.out.print("Enter your option : ");
        Scanner scan = new Scanner(System.in);
        String opt = scan.next();

        switch (opt) {
            case "1": {
                managerScore();
                break;
            }
            case "2": {
                managerStudent();
                break;
            }
        }

    }
}
