package Contact_File;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ContactManager {
    private List<Contact> contacts = new ArrayList<>();

    public void readContactsFromStream(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 3) {
                    Contact contact = new Contact(parts[0], parts[1], parts[2]);
                    contacts.add(contact);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addContact(String firstName, String lastName, String phoneNumber) {
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        contacts.add(contact);
    }

    public void modifyContact(String oldFirstName, String oldLastName, String newFirstName, String newLastName, String newPhoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equals(oldFirstName) && contact.getLastName().equals(oldLastName)) {
                contact = new Contact(newFirstName, newLastName, newPhoneNumber);
            }
        }
    }

    public void deleteContact(String firstName, String lastName) {
        contacts.removeIf(contact -> contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName));
    }

    public void saveContactsToStream(OutputStream outputStream) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
            for (Contact contact : contacts) {
                writer.write(contact.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();

        // Load contacts from an input stream (e.g., a file)
        InputStream inputStream = ContactManager.class.getResourceAsStream("contacts.txt");
        contactManager.readContactsFromStream(inputStream);

        // Example: Add a new contact
        contactManager.addContact("Thai", "Le", "147850011");

        // Example: Modify an existing contact
        contactManager.modifyContact("John", "Doe", "Jane", "Smith", "555-5678");

        // Example: Delete a contact
        contactManager.deleteContact("Alice", "Johnson");

        for (Contact contact : contactManager.contacts) {
            System.out.println(contact);
        }

        // Save the updated contacts to an output stream (e.g., a file)
        //OutputStream outputStream = System.out; // Use System.out for printing to the console
        //contactManager.saveContactsToStream(outputStream);
    }
}