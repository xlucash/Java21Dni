package me.xlucash.dzien20;

import java.sql.*;
import java.util.HashMap;

public class DmozHandlerImpl implements DmozHandler {

    @Override
    public HashMap getRandomSite() {
        Connection conn = getMySqlConnection();
        HashMap<String, String> response = new HashMap<>();
        try
        {
            Statement st = conn.createStatement();
            ResultSet rec = st.executeQuery("SELECT * FROM cooldata ORDER BY RAND() LIMIT 1");
            if(rec.next())
            {
                response.put("url", rec.getString("url"));
                response.put("title", rec.getString("title"));
                response.put("description", rec.getString("description"));
            } else {
                response.put("error", "nie znaleziono rekordu bazy danych");
            }
            st.close();
            rec.close();
            conn.close();
        } catch (SQLException sqe)
        {
            response.put("error", sqe.getMessage());
        }
        return response;
    }

    private Connection getMySqlConnection()
    {
        Connection conn = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/cool", "root", "admin123");
        } catch (SQLException s)
        {
            System.out.println("Błąd SQL: "+s.toString()+" "+s.getErrorCode()+" "+s.getSQLState());
        } catch (Exception e)
        {
            System.out.println("Błąd: "+e.toString()+e.getMessage());
        }
        return conn;
    }
}
