package me.xlucash.dzien12;

import com.sun.source.doctree.SummaryTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Calculator extends JFrame implements FocusListener {
    JTextField value1, value2, sum;
    JLabel plus, equals;

    public Calculator()
    {
        super("Dodaj dwie liczby");
        setSize(350, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLookAndFeel();
        FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
        setLayout(flow);

        value1 = new JTextField("0",5);
        plus = new JLabel("+");
        value2 = new JTextField("0",5);
        equals = new JLabel("=");
        sum = new JTextField("0",5);

        value1.addFocusListener(this);
        value2.addFocusListener(this);

        sum.setEditable(false);
        add(value1);
        add(plus);
        add(value2);
        add(equals);
        add(sum);
        setVisible(true);
    }

    @Override
    public void focusGained(FocusEvent e) {
        try {
            float total = Float.parseFloat(value1.getText()) + Float.parseFloat(value2.getText());
            sum.setText(""+total);
        } catch (NumberFormatException nfe)
        {
            value1.setText("0");
            value2.setText("0");
            sum.setText("0");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        focusGained(e);
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
        Calculator calculator = new Calculator();
    }
}
