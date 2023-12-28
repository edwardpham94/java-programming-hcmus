public class Student {
    String name;
    String id;
    double gpa;

    public Student(String a, String b, double c) {
        name = a;
        id = b;
        gpa = c;
    }

    @Override
    public String toString() {
        return name + " " + id + " " + gpa;
    }
}
