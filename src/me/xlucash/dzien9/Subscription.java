package me.xlucash.dzien9;

import javax.swing.*;

public class Subscription extends JFrame {
    String[] subs = { "Burningbird", "Freeform Goodness", "Ideoplex", "Inessential", "Intertwingly", "Now This",
            "Rasterweb", "RC3", "Whole Lotta Nothing", "Workbench" };
    JList<String> subList = new JList<>(subs);
    public Subscription()
    {
        super("Subskrypcje");
        setSize(150,350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JLabel subLabel = new JLabel("Subskrypcje RSS:");
        panel.add(subLabel);
        subList.setVisibleRowCount(8);
        JScrollPane scroller = new JScrollPane(subList);
        panel.add(scroller);
        add(panel);
        setVisible(true);

    }

    private static void setLookAndFeel()
    {
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception ex){
        }
    }

    public static void main(String[] args) {
        Subscription.setLookAndFeel();
        Subscription app = new Subscription();
    }
}
