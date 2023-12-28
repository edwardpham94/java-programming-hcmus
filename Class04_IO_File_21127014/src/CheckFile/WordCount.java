package CheckFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WordCount {
    public static void main(String[] args) {
        // Load the text file as a resource from the same package
        InputStream fileStream = WordCount.class.getResourceAsStream("file1.txt");

        if (fileStream == null) {
            System.err.println("File not found.");
            return;
        }

        try {
            int wordCount = countWords(fileStream);
            System.out.println("Number of words in the file: " + wordCount);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public static int countWords(InputStream fileStream) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream))) {
            int count = 0;
            String line;

            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                count += tokenizer.countTokens();
            }

            return count;
        }
    }
}

