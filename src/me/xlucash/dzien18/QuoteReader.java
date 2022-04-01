package me.xlucash.dzien18;

import java.sql.*;

//day 18 projects need Java DB to work fine
public class QuoteReader {
    String ticker;

    public QuoteReader(String ticker) {
        this.ticker = ticker;
    }

    public void readStocks() {
        String data = "jdbc:derby://localhost:1527/sample";
        try (
                Connection conn = DriverManager.getConnection(
                        data, "app", "app");
                Statement st = conn.createStatement()) {

            Class.forName("org.apache.derby.jdbc.ClientDriver");

            ResultSet rec = st.executeQuery(
                    "select TICKER, DATE, OPENPRICE, HIGHPRICE, LOWPRICE,"
                            + " CLOSEPRICE, VOLUME from STOCKS WHERE TICKER = '"
                            + ticker + "' " + "order by DATE");
            boolean hasResults = false;
            while (rec.next()) {
                System.out.println("DATE:\t" + rec.getString(2));
                System.out.println("TICKER:\t" + rec.getString(1));
                System.out.println("OPENPRICE:\t" + rec.getString(3));
                System.out.println("HIGHPRICE:\t" + rec.getString(4));
                System.out.println("LOWPRICE:\t" + rec.getString(5));
                System.out.println("CLOSEPRICE:\t" + rec.getString(6));
                System.out.println("VOLUME:\t" + rec.getString(7));
                System.out.println();
                hasResults = true;
            }
            if (!hasResults) {
                System.out.println("No records found for " + ticker);
            }
            st.close();
        } catch (SQLException s) {
            System.out.println("SQL Error: " + s.toString() + " "
                    + s.getErrorCode() + " " + s.getSQLState());
        } catch (Exception e) {
            System.out.println("Error: " + e.toString()
                    + e.getMessage());
        }
    }

    public static void main(String[] arguments) {
        if (arguments.length < 1) {
            System.out.println("Usage: java QuoteReader ticker");
            System.exit(-1);
        }
        new QuoteReader(arguments[0]).readStocks();
    }
}
