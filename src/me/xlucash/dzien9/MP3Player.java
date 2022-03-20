package me.xlucash.dzien9;

import javax.swing.*;

public class MP3Player extends JFrame{
    JButton play = new JButton("Odtwarzanie");
    JButton stopEject = new JButton("Stop/Wysuń");
    JButton rewind = new JButton("Przewiń w tył");
    JButton fastForward = new JButton("Przewiń w przód");
    JButton pause = new JButton("Pauza");

    public MP3Player(){
        super("MP3 Player");
        setSize(550, 125);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.add(play);
        panel.add(stopEject);
        panel.add(rewind);
        panel.add(fastForward);
        panel.add(pause);
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        MP3Player app = new MP3Player();
    }
}
