package me.xlucash.dzien14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DiceRoller extends JFrame implements ActionListener, PropertyChangeListener {
    JTextField[] total = new JTextField[16];
    JButton roll;
    JTextField quantity;
    DiceWorker worker;

    public DiceRoller() {
        super("Rzucanie kostką");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        setSize(850, 145);

        JPanel topPane = new JPanel();
        GridLayout paneGrid = new GridLayout(1, 16);
        topPane.setLayout(paneGrid);
        for (int i = 0; i < 16; i++) {
            total[i] = new JTextField("0", 4);
            JLabel label = new JLabel((i + 3) + ": ");
            JPanel cell = new JPanel();
            cell.add(label);
            cell.add(total[i]);
            topPane.add(cell);
        }

        JPanel bottomPane = new JPanel();
        JLabel quantityLabel = new JLabel("Liczba rzutów: ");
        quantity = new JTextField("0", 5);
        roll = new JButton("Rzuć");
        roll.addActionListener(this);
        bottomPane.add(quantityLabel);
        bottomPane.add(quantity);
        bottomPane.add(roll);

        GridLayout frameGrid = new GridLayout(2, 1);
        setLayout(frameGrid);
        add(topPane);
        add(bottomPane);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        int timesToRoll;
        try {
            timesToRoll = Integer.parseInt(quantity.getText());
            roll.setEnabled(false);
            worker = new DiceWorker(timesToRoll);
            worker.addPropertyChangeListener(this);
            worker.execute();
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }
    }

    public void propertyChange(PropertyChangeEvent event) {
        try {
            int[] result = (int[]) worker.get();
            for (int i = 0; i < result.length; i++) {
                total[i].setText("" + result[i]);
            }
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
        }
    }

    public static void main(String[] arguments) {
        new DiceRoller();
    }
}
