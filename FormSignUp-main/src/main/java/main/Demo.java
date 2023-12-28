package main;

import ComponentCustom.FormSignUp;

import javax.swing.*;
import java.awt.geom.RoundRectangle2D;

public class Demo extends JFrame {
    public Demo () {
        super();
        setUndecorated(true);
        setSize(400, 470);
        setShape(new RoundRectangle2D.Double(0,0, 400, 470, 40, 40));
        setLocationRelativeTo(null);
        FormSignUp form = new FormSignUp();
        add(form);

    }
    public static void main(String[] args) {
        new Demo().setVisible(true);
    }
}
