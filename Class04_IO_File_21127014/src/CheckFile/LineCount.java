package CheckFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LineCount {
    public static void main(String[] args) {
        // Load the text file as a resource from the same package
        InputStream fileStream = LineCount.class.getResourceAsStream("file1.txt");

        if (fileStream == null) {
            System.err.println("File not found.");
            return;
        }

        try {
            int lineCount = countLines(fileStream);
            System.out.println("Number of lines in the file: " + lineCount);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public static int countLines(InputStream fileStream) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream))) {
            int count = 0;
            while (reader.readLine() != null) {
                count++;
            }
            return count;
        }
    }
}
