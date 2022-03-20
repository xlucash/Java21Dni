package me.xlucash.dzien10;

import javax.swing.*;

public class TabPanels extends JFrame {
    public TabPanels()
    {
        super("Zakładki");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLookAndFeel();
        setSize(480,220);
        JPanel mainSettings = new JPanel();
        JPanel advancedSettings = new JPanel();
        JPanel privacySettings = new JPanel();
        JPanel emailSettings = new JPanel();
        JPanel securitySettings = new JPanel();
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Główna", mainSettings);
        tabs.addTab("Zaawansowana", advancedSettings);
        tabs.addTab("Prywatna", privacySettings);
        tabs.addTab("Email", emailSettings);
        tabs.addTab("Bezpieczeństwo", securitySettings);
        add(tabs);
        setVisible(true);
    }

    private void setLookAndFeel()
    {
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch(Exception ex){
            System.err.println("Nie potrafie wczytac "+ "systemowego wygladu: " + ex);
        }
    }

    public static void main(String[] args) {
        TabPanels tabs = new TabPanels();
    }
}
