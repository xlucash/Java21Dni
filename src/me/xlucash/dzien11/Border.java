package me.xlucash.dzien11;

import javax.swing.*;
import java.awt.*;

public class Border extends JFrame {
    public Border()
    {
        super("Border");
        setSize(250,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLookAndFeel();
        setLayout(new BorderLayout());

        JButton nButton = new JButton("Północ");
        JButton sButton = new JButton("Południe");
        JButton eButton = new JButton("Wschód");
        JButton wButton = new JButton("Zachód");
        JButton cButton = new JButton("Środek");

        add(nButton, BorderLayout.NORTH);
        add(sButton, BorderLayout.SOUTH);
        add(eButton, BorderLayout.EAST);
        add(wButton, BorderLayout.WEST);
        add(cButton,BorderLayout.CENTER);

        setVisible(true);
    }


    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            System.err.println("Nie potrafię wczytać "
                    + "systemowego wyglądu: " + e);
        }
    }

    public static void main(String[] args) {
        Border br = new Border();

    }
}
