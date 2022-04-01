package me.xlucash.dzien18;

import java.sql.*;

//day 18 projects need Java DB to work fine
public class CustomerReport2 {
    public static void main(String[] args) {
        String data = "jdbc:derby://localhost:1527/sample";
        try (Connection conn = DriverManager.getConnection(data, "app","app");
             Statement st = conn.createStatement()) {
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            ResultSet rec = st.executeQuery("select DISCOUNT_CODE, RATE "+"from APP.DISCOUNT_CODE "+"order by RATE DESC");
            while(rec.next())
            {
                System.out.println("DISCOUNT_CODE:\t" + rec.getString(1));
                System.out.println("RATE:\t" + rec.getString(2));
                System.out.println();
            }
            st.close();
        } catch (SQLException s)
        {
            System.out.println("Błąd SQL: "+s.toString()+" "+s.getErrorCode()+" "+s.getSQLState());
        } catch (Exception e)
        {
            System.out.println("Błąd: "+e.toString() + e.getMessage());
        }

    }
}
