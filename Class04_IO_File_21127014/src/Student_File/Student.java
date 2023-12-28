package Student_File;

class Student {
    private String studentId;
    private String firstName;
    private String lastName;
    private double javaGrade;

    public Student(String studentId, String firstName, String lastName, double javaGrade) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.javaGrade = javaGrade;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getJavaGrade() {
        return javaGrade;
    }

    @Override
    public String toString() {
        return studentId + "\t" + firstName + "\t" + lastName + "\t" + javaGrade;
    }
}
