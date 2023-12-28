package ChatUI;

import javax.swing.*;
import java.awt.*;

public class GradientBackgroundExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Gradient Background Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a custom content pane with gradient background
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Draw gradient background
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(135, 206, 250); // Light Sky Blue
                Color color2 = new Color(70, 130, 180); // Steel Blue
                GradientPaint gradient = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        // Set the custom content pane to the frame
        frame.setContentPane(contentPane);

        // Add components to the content pane
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        contentPane.add(button1);
        contentPane.add(button2);

        // Set frame properties
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }
}

