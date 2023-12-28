package Swing;

import javax.swing.*;
import java.awt.*;

public class JLabelDemo extends JFrame {
    public JLabelDemo() {
        Container cp = getContentPane();
        ImageIcon ii = new ImageIcon("gallery.png");
        JLabel jl = new JLabel("Hourglass", ii,
                JLabel.CENTER);
        cp.add(jl);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new JLabelDemo();
    }
}