public class Student {
    String StudentID;
    String FullName;
    String DOB;
    private static int instanceCount = 0;

    Student(){
        StudentID = "0000000";
        FullName = "AAA";
        DOB = "00/00/0000";
        instanceCount++;
    }

    Student(String a, String b, String c){
        StudentID = a;
        FullName = b;
        DOB = c;
        instanceCount++;
    }

    String getStudentID(){
        return this.StudentID;
    }

    String getFullName(){
        return this.FullName;
    }

    String getDOB(){
        return this.DOB;
    }

    int getInstanceCount(){
        return Student.instanceCount;
    }

    @Override
    public String toString() {
        return "StudentID: " + StudentID + "\n FullName: " + FullName + "\n DOB: " + DOB;
    }

    public static void main(String[] str){
        Student student1 = new Student("21127014", "Phạm Hồng Gia Bảo", "09/04/2003");

        System.out.println("NUmber of Instance: " + student1.getInstanceCount());

        System.out.println(student1);
    }
}
