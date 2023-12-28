package Swing;

import javax.swing.*;
public class SwingDemo {
    public SwingDemo() {
    JFrame jfrm = new JFrame("A Simple Swing Application");
    jfrm.setSize(300, 300);
// Terminate the program when the user closes
// the application.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel jlab = new JLabel(" HELLO.");
        jfrm.add(jlab);
        jfrm.setVisible(true);
    }
}