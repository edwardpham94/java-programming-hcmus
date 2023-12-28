package Contact;

public class Contact {
    private String firstName;
    private String lastName;
    private String phone;

    public Contact(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setFirstName(String a) {
        firstName = a;
    }

    public void setLastName(String a) {
        lastName = a;
    }
    public void setPhone(String a) {
        phone = a;
    }


    @Override
    public String toString() {
        return firstName + "\t" + lastName + "\t" + phone;
    }
}