
import CompareFile.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String path1 = "file1.txt";
        String path2 = "file2.txt";
        try {
            FileReader fr1 = new FileReader(path1);
            FileReader fr2 = new FileReader(path2);

            CompareFile x = new CompareFile();
            x.equalFile(fr1, fr2);


            fr1.close();
            fr2.close();

        } catch (IOException e) {
            System.out.println("One or both files are not found!");
        }
    }
}