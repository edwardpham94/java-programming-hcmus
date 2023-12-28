package CheckFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CompareFiles {
    public static boolean areFilesEqual(InputStream file1Stream, InputStream file2Stream) throws IOException {
        try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(file1Stream));
             BufferedReader reader2 = new BufferedReader(new InputStreamReader(file2Stream))) {
            String line1, line2;

            while ((line1 = reader1.readLine()) != null) {
                line2 = reader2.readLine();
                if (!line1.equals(line2)) {
                    return false; // Files have different content
                }
            }

            // Check if file2 has more content
            return reader2.readLine() == null;
        }
    }

    public static void main(String[] args) {
        // Load the text files as resources from the same package
        InputStream file1Stream = CompareFiles.class.getResourceAsStream("file1.txt");
        InputStream file2Stream = CompareFiles.class.getResourceAsStream("file2.txt");

        if (file1Stream == null || file2Stream == null) {
            System.err.println("One or both files not found.");
            return;
        }

        try {
            if (areFilesEqual(file1Stream, file2Stream)) {
                System.out.println("The files have the same content.");
            } else {
                System.out.println("The files do not have the same content.");
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}

