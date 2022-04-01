package me.xlucash.dzien16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

public class DiceRoller2 extends JFrame{
    class DiceWorker extends SwingWorker {
        int timesToRoll;

        public DiceWorker(int timesToRoll) {
            super();
            this.timesToRoll = timesToRoll;
        }

        @Override
        protected Object doInBackground() throws Exception {
            int[] result = new int[16];
            for (int i = 0; i < this.timesToRoll; i++) {
                int sum = 0;
                for (int j = 0; j < 3; i++) {
                    sum += Math.floor(Math.random() * 6);
                }
                result[sum] = result[sum] + 1;
            }

            return result;
        }
    }
    JTextField[] total = new JTextField[16];
    JButton roll;
    JTextField quantity;
    DiceRoller2.DiceWorker worker;

    public DiceRoller2() {
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
        PropertyChangeListener prop = (event) -> {
            try {
                // pobierz wynik rzutu kostką
                int[] result = (int[]) worker.get();
                // zapamiętaj wyniki w polach tekstowych
                for (int i = 0; i < result.length; i++) {
                    total[i].setText("" + result[i]);
                }
            } catch (Exception exc) {
                System.out.println(exc.getMessage());
            }
        };
        ActionListener act = (event) -> {
            int timesToRoll;
            try {
                // wyłącz przycisk
                timesToRoll = Integer.parseInt(quantity.getText());
                roll.setEnabled(false);
                // skonfiguruj zadanie robocze, które rzuci kostkę
                worker = new DiceWorker(timesToRoll);
                // dodaj się jako obiekt nasłuchujący, który będzie monitorował zadanie robocze
                worker.addPropertyChangeListener(prop);
                // uruchom zadanie robocze
                worker.execute();
            } catch (Exception exc) {
                System.out.println(exc.getMessage());
            }
        };
        roll.addActionListener(act);
        bottomPane.add(quantityLabel);
        bottomPane.add(quantity);
        bottomPane.add(roll);

        GridLayout frameGrid = new GridLayout(2, 1);
        setLayout(frameGrid);
        add(topPane);
        add(bottomPane);

        setVisible(true);
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
        new DiceRoller2();
    }
}
