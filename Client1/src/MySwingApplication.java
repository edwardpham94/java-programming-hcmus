import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MySwingApplication {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("My Swing Application");

        // Add components, set layout, etc.

        // Add a WindowAdapter to handle window-closing event
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("ok");
                System.exit(0); // Exit the application

            }
        });

        // Set the default close operation to EXIT_ON_CLOSE
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up the frame and make it visible
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
