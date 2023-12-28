package StudentManager;

public class Student {
    int id;
    String name;
    String dob;
    String url;

    public Student(int a, String b, String d, String e) {
        id = a;
        name = b;
        dob = d;
        url = e;
    }

    public void setId(int a) {
        id = a;
    }

    public void setname(String a) {
        name = a;
    }
    public void setDOB(String a) {
        dob = a;
    }

    public void seturl(String a) {
        url = a;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDOB() {
        return dob;
    }

    public String getUrl() {
        return url;
    }


}
