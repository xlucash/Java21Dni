package me.xlucash.dzien9;

import javax.swing.*;

public class Authenticator extends JFrame {
    JTextField username = new JTextField(15);
    JPasswordField password = new JPasswordField(15);
    JTextArea comments = new JTextArea(4, 15);
    JButton ok = new JButton("OK");
    JButton cancel = new JButton("Anuluj");

    public Authenticator() {
        super("Informacje o koncie");
        setSize(300,220);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel usernameLabel = new JLabel("Użytkownik: ");
        JLabel passwordLabel = new JLabel("Hasło: ");
        JLabel commentsLabel = new JLabel("Komentarz: ");

        comments.setLineWrap(true);
        comments.setWrapStyleWord(true);

        panel.add(usernameLabel);
        panel.add(username);
        panel.add(passwordLabel);
        panel.add(password);
        panel.add(commentsLabel);
        panel.add(comments);
        panel.add(ok);
        panel.add(cancel);
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
        setLookAndFeel();
        Authenticator app = new Authenticator();
    }

}
