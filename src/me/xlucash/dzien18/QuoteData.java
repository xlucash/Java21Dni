package me.xlucash.dzien18;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

//day 18 projects need Java DB to work fine
public class QuoteData {
    private final String ticker;

    public QuoteData(String inTicker) {
        ticker = inTicker;
    }

    private String retrieveQuote() {
        StringBuilder builder = new StringBuilder();
        try {
            URL page = new URL(
                    "https://www.wsj.com/market-data/quotes/" + ticker
                            + "/historical-prices/download?"
                            + "num_rows=1");
            String line;
            URLConnection conn = page.openConnection();
            conn.connect();
            conn = page.openConnection();
            conn.addRequestProperty("User-Agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
            InputStreamReader in = new InputStreamReader(
                    conn.getInputStream());
            BufferedReader data = new BufferedReader(in);
            while ((line = data.readLine()) != null) {
                if (line.contains("Date")) continue;
                builder.append(line);
                builder.append("\n");
            }
        } catch (MalformedURLException mue) {
            System.out.println("Bad URL: " + mue.getMessage());
        } catch (IOException ioe) {
            System.out.println("IO Error:" + ioe.getMessage());
        }
        return builder.toString();
    }

    private void storeQuote(String data) {
        StringTokenizer tokens = new StringTokenizer(data, ",");
        String[] fields = new String[6];
        for (int i = 0; i < fields.length; i++) {
            fields[i] = stripQuotes(tokens.nextToken());
        }
        String datasource = "jdbc:derby://localhost:1527/sample";
        try (
                Connection conn = DriverManager.getConnection(
                        datasource, "app", "app")
        ) {

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            PreparedStatement prep2 = conn.prepareStatement(
                    "insert into " +
                            "APP.STOCKS(TICKER, DATE, OPENPRICE, HIGHPRICE, " +
                            "LOWPRICE, CLOSEPRICE, VOLUME) " +
                            "values(?, ?, ?, ?, ?, ?, ?)");
            prep2.setString(1, ticker);
            prep2.setString(2, fields[0]);
            prep2.setString(3, fields[1]);
            prep2.setString(4, fields[2]);
            prep2.setString(5, fields[3]);
            prep2.setString(6, fields[4]);
            prep2.setString(7, fields[5]);
            prep2.executeUpdate();
            prep2.close();
            conn.close();
        } catch (SQLException sqe) {
            System.out.println("SQL Error: " + sqe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        }
    }

    private String stripQuotes(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != '\"') {
                output.append(input.charAt(i));
            }
        }
        return output.toString();
    }

    public static void main(String[] arguments) {
        if (arguments.length < 1) {
            System.out.println("Usage: java QuoteData ticker");
            System.exit(0);
        }
        QuoteData qd = new QuoteData(arguments[0]);
        String data = qd.retrieveQuote();
        qd.storeQuote(data);
    }
}
