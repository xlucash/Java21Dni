package me.xlucash.dzien10;

import javax.swing.*;
import java.awt.*;

public class FeedBar2 extends JFrame {
    public FeedBar2()
    {
        super("Pasek narzędziowy 2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLookAndFeel();

        ImageIcon loadIcon = new ImageIcon("load.gif");
        ImageIcon saveIcon = new ImageIcon("save.gif");
        ImageIcon subIcon = new ImageIcon("subscribe.gif");
        ImageIcon unsubIcon = new ImageIcon("unsubscribe.gif");

        JButton load = new JButton("Wczytaj",loadIcon);
        JButton save = new JButton("Zapisz",saveIcon);
        JButton sub = new JButton("Zarejestruj",subIcon);
        JButton unsub = new JButton("Wyrejestruj",unsubIcon);

        JToolBar bar = new JToolBar();
        bar.add(load);
        bar.add(save);
        bar.add(sub);
        bar.add(unsub);

        JMenuItem j1 = new JMenuItem("Wczytaj");
        JMenuItem j2 = new JMenuItem("Zapisz");
        JMenuItem j3 = new JMenuItem("Zarejestruj");
        JMenuItem j4 = new JMenuItem("Wyrejestruj");

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Źródła danych");
        menu.add(j1);
        menu.add(j2);
        menu.addSeparator();
        menu.add(j3);
        menu.add(j4);
        menuBar.add(menu);

        JTextArea edit = new JTextArea(8,40);
        JScrollPane scroll = new JScrollPane(edit);
        BorderLayout bord = new BorderLayout();
        setLayout(bord);
        add("North", bar);
        add("Center",scroll);
        setJMenuBar(menuBar);
        pack();
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
        FeedBar2 frame = new FeedBar2();
    }
}
