package Copy_File;

import java.io.*;
import java.sql.SQLOutput;

class CopyFile1 {
    public static void main(String[] a) throws IOException {
        String[] args = {"E:\\YEAR3_HK1\\JAVA_INTELLIJ\\Class04_IO_File_21127014\\src\\Copy_File\\email_test.txt", "E:\\YEAR3_HK1\\JAVA_INTELLIJ\\Class04_IO_File_21127014\\src\\Copy_File\\output.txt"};
        int i;
        System.out.println(args[0] + " " + args[1]);
// First, confirm that both files has been specified.
        if (args.length != 2) {
            System.out.println("Usage: CopyFile from to");
            return;
        }
// Open and manage two files via the try statement.
        try (FileInputStream fin = new FileInputStream(args[0]);
             FileOutputStream fout = new FileOutputStream(args[1])) {
            do {
                i = fin.read();
                if (i != -1) fout.write(i);
            } while (i != -1);
        } catch (IOException exc) {
            System.out.println("I/O Error: " + exc);
        }
    }
}