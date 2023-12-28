package ComponentCustom;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TextFieldCustom extends JPanel {
    private final JLabel lbltitle;
    private final JTextField txttitle;
    private final JLabel lblicon;
    private int yLocate = 25;
    public TextFieldCustom (String title, String url) {
        setLayout(null);
        setOpaque(false);
        setBackground(null);
        FontCustom cus = new FontCustom();
        setBorder(new MatteBorder(0,0,1,0, Color.BLACK));

        // 340 60
        lbltitle = new JLabel(title);
        lbltitle.setFont(cus.customFont17);
        lbltitle.setBounds(0, yLocate, 150, 30);
        add(lbltitle);

        txttitle = new JTextField();
        txttitle.setFont(cus.customFont17);
        txttitle.setBounds(0, 30, 310, 30);
        txttitle.setOpaque(false);
        txttitle.setBackground(null);
        txttitle.setBorder(null);
        add(txttitle);

        lblicon = new JLabel();
        lblicon.setIcon(new ImageIconCustom(url, 30, 30));
        lblicon.setBounds((340 - 30) ,  30, 30, 30);
        add(lblicon);

        txttitle.addFocusListener(new FocusListener() {
            private Timer t;

            @Override
            public void focusGained(FocusEvent e) {
                if (txttitle.getText().equals("")) {
                    t = new Timer(1, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (yLocate > 5) {
                                yLocate --;
                                lbltitle.setBounds(0, yLocate, 150, 30);
                                invalidate();
                                validate();
                                repaint();
                            }else {
                                t.stop();
                            }
                        }
                    });
                    t.start();
                } else {
                    t.stop();
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txttitle.getText().equals("")) {
                    t = new Timer(1, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (yLocate < 25) {
                                yLocate ++;
                                lbltitle.setBounds(0, yLocate, 150, 30);
                                invalidate();
                                validate();
                                repaint();
                            } else {
                                t.stop();
                            }
                        }
                    });
                    t.start();
                }else {
                    t.stop();
                }

            }
        });
    }
}
