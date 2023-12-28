package CompareFile;

import java.io.*;

public class CompareFile {
    public void equalFile(FileReader fr1, FileReader fr2) throws IOException {
        BufferedReader br1 = new BufferedReader(fr1);
        BufferedReader br2 = new BufferedReader(fr2);

        String str1, str2;
        int lineNumbers = 0;

        while (true) {
            str1 = br1.readLine();
            str2 = br2.readLine();
            lineNumbers = lineNumbers + 1;

            if (str1 == null || str2 == null) {
                break;
            }

            int minLength = Math.min(str1.length(), str2.length());

            for (int i = 0; i < minLength; i++) {
                if (Character.toLowerCase(str1.charAt(i)) != Character.toLowerCase(str2.charAt(i))) {
                    System.out.println("Two files are different.");
                    System.out.println("The position where the files differ in: line " + lineNumbers + ", index = " + i);
                    return;
                }
            }

            if (str1.length() != str2.length()) {
                System.out.println("Two files are different.");
                System.out.println("The position where the files differ in: line " + lineNumbers + ", index = " + minLength);
                return;
            }
        }

        System.out.println("Two files are the same.");
        return;
    }


}
