package me.xlucash.dzien11;

import javax.swing.*;
import java.awt.*;

public class Bunch extends JFrame {
    public Bunch()
    {
        super("Bunch");
        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLookAndFeel();
        JPanel pane = new JPanel();
        GridLayout family = new GridLayout(3,3,10,10);
        pane.setLayout(family);

        JButton marcia = new JButton("Marcin");
        JButton carol = new JButton("Karol");
        JButton greg = new JButton("Grzegorz");
        JButton jan = new JButton("Jan");
        JButton alice = new JButton("Alicja");
        JButton peter = new JButton("Piotr");
        JButton cindy = new JButton("Cecylia");
        JButton mike = new JButton("Michał");
        JButton hobby = new JButton("Robert");

        pane.add(marcia);
        pane.add(carol);
        pane.add(greg);
        pane.add(jan);
        pane.add(alice);
        pane.add(peter);
        pane.add(cindy);
        pane.add(mike);
        pane.add(hobby);

        add(pane);
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
        Bunch bunch = new Bunch();
    }
}
