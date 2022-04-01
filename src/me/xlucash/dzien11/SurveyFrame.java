package me.xlucash.dzien11;

import javax.swing.*;

public class SurveyFrame extends JFrame {
    public SurveyFrame()
    {
        super("Ankieta");
        setSize(300,150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLookAndFeel();
        SurveyWizard wiz = new SurveyWizard();
        add(wiz);
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
        SurveyFrame surv = new SurveyFrame();
    }
}
