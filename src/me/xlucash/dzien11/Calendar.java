package me.xlucash.dzien11;

import javax.swing.*;
import java.awt.*;

public class Calendar extends JFrame {
    JLabel[] days = new JLabel[31];
    JLabel[] dayTitles = new JLabel[7];
    JLabel monthTitle = new JLabel("Marzec 2022");

    Calendar() {
        super("Kalendarz");
        setSize(250, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flow = new FlowLayout();
        setLayout(flow);
        JPanel titlePane = new JPanel();
        titlePane.setLayout(flow);
        titlePane.add(monthTitle);
        add(titlePane);
        JPanel monthPane = new JPanel();
        GridLayout calLayout = new GridLayout(6, 7);
        monthPane.setLayout(calLayout);
        String[] dayNames = { "Nie", "Pon", "Wto", "Śro", "Czw", "Pią", "Sob" };
        for (int i = 0; i < 7; i++) {
            dayTitles[i] = new JLabel(dayNames[i]);
            monthPane.add(dayTitles[i]);
        }
        for (int i = 0; i < days.length; i++) {
            days[i] = new JLabel("" + (i+1));
            monthPane.add(days[i]);
        }
        add(monthPane);
        setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Nie potrafię wczytać " + "systemowego wyglądu: " + e);
        }
    }


    public static void main(String[] arguments) {
        Calendar.setLookAndFeel();
        Calendar cal = new Calendar();
    }
}