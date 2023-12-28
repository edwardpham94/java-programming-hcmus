package ComponentCustom;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ComfimButton extends JButton {
    private final JLabel lblName;

    public ComfimButton () {
        setLayout(null);
        setContentAreaFilled(false);
        setBackground(null);
        setOpaque(false);
        setBorder(null);

        lblName = new JLabel("Register");
        lblName.setFont(new FontCustom().customFont17);
        lblName.setForeground(Color.white);
        lblName.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        lblName.setBounds((340 - 70) / 2, 11, 70, 30);
        add(lblName);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblName.setBorder(new MatteBorder(0,0,1,0,Color.white));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblName.setBorder(null);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth(), h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#111111"), w, h, Color.decode("#111111"));
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, w, h,20,20);
    }
}
