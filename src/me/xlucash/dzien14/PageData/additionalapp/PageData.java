package me.xlucash.dzien14.PageData.additionalapp;

import javax.swing.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.awt.*;

public class PageData extends JFrame implements ActionListener,
        Runnable {

    Thread runner;
    String[] headers = { "Content-Length", "Content-Type",
            "Date", "Public", "Expires", "Last-Modified",
            "Server" };

    URL page;
    JTextField url;
    JLabel[] headerLabel = new JLabel[7];
    JTextField[] header = new JTextField[7];
    JButton readPage, clearPage, quitLoading;
    JLabel status;

    public PageData() {
        super("Dane strony");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        setLayout(new GridLayout(10, 1));

        JPanel first = new JPanel();
        first.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel urlLabel = new JLabel("URL:");
        url = new JTextField(22);
        urlLabel.setLabelFor(url);
        first.add(urlLabel);
        first.add(url);
        add(first);

        JPanel second = new JPanel();
        second.setLayout(new FlowLayout());
        readPage = new JButton("Odczytaj stronę");
        clearPage = new JButton("Wyczyść pola");
        quitLoading = new JButton("Zamknij wczytywanie");
        readPage.setMnemonic('o');
        clearPage.setMnemonic('w');
        quitLoading.setMnemonic('z');
        readPage.setToolTipText("Rozpocznij wczytywanie strony");
        clearPage.setToolTipText("Wyczyść wszystkie pola nagłówków");
        quitLoading.setToolTipText("Zamknij wczytywanie strony");
        readPage.setEnabled(true);
        clearPage.setEnabled(false);
        quitLoading.setEnabled(false);
        readPage.addActionListener(this);
        clearPage.addActionListener(this);
        quitLoading.addActionListener(this);
        second.add(readPage);
        second.add(clearPage);
        second.add(quitLoading);
        add(second);

        JPanel[] row = new JPanel[7];
        for (int i = 0; i < 7; i++) {
            row[i] = new JPanel();
            row[i].setLayout(new FlowLayout(FlowLayout.RIGHT));
            headerLabel[i] = new JLabel(headers[i] + ":");
            header[i] = new JTextField(22);
            headerLabel[i].setLabelFor(header[i]);
            row[i].add(headerLabel[i]);
            row[i].add(header[i]);
            add(row[i]);
        }

        JPanel last = new JPanel();
        last.setLayout(new FlowLayout(FlowLayout.LEFT));
        status = new JLabel("Wpisz adres URL do sprawdzenia.");
        last.add(status);
        add(last);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        if (source == readPage) {
            try {
                page = new URL(url.getText());
                if (runner == null) {
                    runner = new Thread(this);
                    runner.start();
                }
                quitLoading.setEnabled(true);
                readPage.setEnabled(false);
            }
            catch (MalformedURLException e) {
                status.setText("Zły URL: " + page);
            }
        } else if (source == clearPage) {
            for (int i = 0; i < 7; i++)
                header[i].setText("");
            quitLoading.setEnabled(false);
            readPage.setEnabled(true);
            clearPage.setEnabled(false);
        } else if (source == quitLoading) {
            runner = null;
            url.setText("");
            quitLoading.setEnabled(false);
            readPage.setEnabled(true);
            clearPage.setEnabled(false);
        }
    }

    public void run() {
        URLConnection conn;
        try {
            conn = this.page.openConnection();
            conn.connect();
            status.setText("Połączenie otwarte...");
            for (int i = 0; i < 7; i++)
                header[i].setText(conn.getHeaderField(headers[i]));
            quitLoading.setEnabled(false);
            clearPage.setEnabled(true);
            status.setText("Gotowe");
            runner = null;
        }
        catch (IOException e) {
            status.setText("Błąd wejścia-wyjścia:" + e.getMessage());
        }
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            // ignoruj błędy
        }
    }


    public static void main(String[] arguments) {
        PageData frame = new PageData();
    }
}
