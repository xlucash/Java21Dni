package me.xlucash.dzien12.mouseprank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MousePrank extends JFrame implements ActionListener {

    public MousePrank()
    {
        super("Komunikat");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(420,220);
        BorderLayout border = new BorderLayout();
        setLayout(border);
        JLabel msg = new JLabel("Kliknij OK, aby zamknąć program");
        add(BorderLayout.NORTH, msg);
        PrankPanel prank = new PrankPanel();
        add(BorderLayout.CENTER, prank);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    public Insets getInsets()
    {
        return new Insets(40, 10, 10, 10);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception e) {
            System.err.println("Nie potrafię wczytać "
                    + "systemowego wyglądu: " + e);
        }
    }

    public static void main(String[] args) {
        MousePrank.setLookAndFeel();
        new MousePrank();
    }
}
