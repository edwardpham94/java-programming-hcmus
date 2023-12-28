package Contact;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Contact_Manager {
    public List<Contact> students = new ArrayList<>();

    public void readStudentFile(String filePath)  {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while (true){
                line = br.readLine();
                if (line == null){
                    break;
                }
                String[] str = line.split("\\t");
                Contact tmp = new Contact(str[0], str[1], str[2]);
                students.add(tmp);
            }
        } catch (IOException e){
            System.out.println("Error : " + e);
        }

    }

    public void display(){
        for (Contact i : students){
            System.out.println(i);
        }
    }

    public void modifyContact(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter First Name to modify : ");
        String name = scanner.nextLine();
        for (Contact i : students) {
            if (i.getFirstName().equals(name)){
                System.out.println("1. Modify First Name.");
                System.out.println("2. Modify Last Name.");
                System.out.println("3. Modify Phone Number");
                int opt = scanner.nextInt();
                scanner.nextLine();
                switch (opt) {
                    case 1: {
                        System.out.print("Fill new : ");
                        String modify = scanner.nextLine();
                        i.setFirstName(modify);
                        break;
                    }

                    case 2: {
                        System.out.print("Fill new : ");
                        String modify = scanner.nextLine();
                        i.setLastName(modify);
                        break;
                    }

                    case 3: {
                        System.out.print("Fill new : ");
                        String modify = scanner.nextLine();
                        i.setPhone(modify);
                        break;
                    }
                }
            }
        }
        System.out.println("Not existed!");
        return;
    }

    public void addContact(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter First Name : ");
        String first = scanner.nextLine();
        System.out.print("Enter Last Name : ");
        String last = scanner.nextLine();
        System.out.print("Enter Phone : ");
        String phone = scanner.nextLine();
        Contact tmp = new Contact(first, last, phone);
        students.add(tmp);
    }

    public void deleteContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("DELETE CONTACT");
        System.out.print("Enter First Name to delete: ");
        String name = scanner.nextLine();

        Contact foundContact = null;
        for (Contact contact : students) {
            if (contact.getFirstName().equals(name)) {
                foundContact = contact;
                break;
            }
        }

        if (foundContact != null) {
            students.remove(foundContact);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void optionManager(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add contact");
        System.out.println("2. Modify contact");
        System.out.println("3. Remove contact");
        System.out.println("OPT ur choice: ");
        String optChoice = scanner.nextLine();
        switch (optChoice){
            case "1": {
                addContact();
                break;
            }
            case "2": {
                modifyContact();
                break;
            }
            case "3": {
                deleteContact();
                break;
            }
        }
    }

    public void dataOutFile(String path){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

            for (Contact i : students) {
                bw.write(String.valueOf(i));
                bw.newLine();
            }

            bw.close();
        } catch (IOException e){
            System.out.println("Error " + e);
        }
    }
}
