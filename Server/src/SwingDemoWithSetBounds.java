import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingDemoWithSetBounds {

    public static void main(String[] args) {
        // Create a JFrame (window)
        JFrame frame = new JFrame("Swing Demo");

        // Create a JButton
        JButton button = new JButton("Click Me");

        // Set the bounds (x, y, width, height) for the button
        button.setBounds(50, 50, 100, 30);

        // Add an ActionListener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked!");
            }
        });

        // Add the button to the content pane of the frame
        frame.add(button);

        // Set the default close operation for the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the frame
        frame.setSize(300, 200);

        // Set the layout manager to null to allow manual component placement
        frame.setLayout(null);

        // Set the frame to be visible
        frame.setVisible(true);
    }
}
