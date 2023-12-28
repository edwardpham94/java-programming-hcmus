import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "input.txt";

//        Student n1 = new Student("Bao Pham", "21127014", 10) ;
//        Student n2 = new Student("Bao Pham", "21127014", 10) ;
//        Student n3 = new Student("Bao Pham", "21127014", 10) ;
        List<Student> list = new ArrayList<>();

//        list.add(n1);
//        list.add(n2);
//        list.add(n3);

        try {
            FileReader fw = new FileReader(filePath);
            BufferedReader bw = new BufferedReader(fw);
            String line = "" ;
            while (true) {
                line = bw.readLine();

                if (line == null){
                    break;
                }

                String[] txt = line.split(";");
                Student tmp = new Student(txt[0], txt[1], Double.parseDouble(txt[2]));
                list.add(tmp);
            }

        } catch  (Exception e){
            System.out.println("Error " + e);
        }

        finally {
            for (Student i : list){
                System.out.println(i);
            }
        }
    }
}