package Student_Manager;

public class Student {
    private String name;
    private String id;
    private String phoneNumber;
    private double midScore;
    private double finalScore;
    private double projectScore;

    private double gpa;

    public Student(){
        name = "";
        id = "";
        phoneNumber = "";
        midScore = 0;
        finalScore = 0;
        projectScore = 0;
    }

    public Student(String a, String b, String c, double d, double e, double f) {
        name = a;
        id = b;
        phoneNumber = c;
        midScore = d;
        finalScore = e;
        projectScore = f;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getMid() {
        return midScore;
    }

    public double getFinal() {
        return finalScore;
    }

    public double getProject() {
        return projectScore;
    }

    public void setName(String a){
        name = a;
    }

    public void setID(String a){
        name = a;
    }

    public void setPhoneNumber(String a){
        name = a;
    }

    public void setMidScore(Double x){
        midScore = x;
    }

    public void setFinalScore(Double x){
        finalScore = x;
    }

    public void setProjectScore(Double x){
        projectScore = x;
    }

    @Override
    public String toString() {
        return name + "\t" + id + "\t" + phoneNumber + "\t" + projectScore + "\t" + midScore + "\t" + finalScore;
    }
}
