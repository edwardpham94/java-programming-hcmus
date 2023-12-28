import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Contact.*;

public class Main {
    public static void main(String[] args) {
        Contact_Manager listContact = new Contact_Manager();

        String filePath = "contact.txt";

        listContact.readStudentFile(filePath);

        listContact.optionManager();

        listContact.display();

        listContact.dataOutFile("outputContact");
    }
}