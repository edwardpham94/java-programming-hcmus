package StudentManager;

import java.util.ArrayList;

public class ListStudent {
    ArrayList<Student> list = new ArrayList<>();

    public void addStudent(Student tmp) {
        list.add(tmp);
    }

    public int getSize() {
        return list.size();
    }

    public Student getStudent(int x) {
        return list.get(x);
    }
}
