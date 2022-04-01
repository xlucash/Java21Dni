package me.xlucash.dzien11;

import javax.swing.*;
import java.awt.*;

public class Alphabet extends JFrame {
    public Alphabet()
    {
        super("Alphabet");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLookAndFeel();
        setSize(350,125);
        FlowLayout lm = new FlowLayout(FlowLayout.LEFT, 30, 10);
        setLayout(lm);
        JButton a = new JButton("Alibi");
        JButton b = new JButton("Biurko");
        JButton c = new JButton("Ciało");
        JButton d = new JButton("Dowód");
        JButton e = new JButton("Ekran");
        JButton f = new JButton("Fasada");
        add(a);
        add(b);
        add(c);
        add(d);
        add(e);
        add(f);
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
        Alphabet frame = new Alphabet();

    }
}
