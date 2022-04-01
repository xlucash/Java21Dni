package me.xlucash.dzien17;

import java.net.*;
import java.io.*;

public class WebSaver {
    URL page;
    public WebSaver(String address) throws MalformedURLException
    {
        page = new URL(address);
    }

    void getData()
    {
        String filename = page.getHost() + "_" + page.getFile() + "_file.html";
        File output = new File(filename);
        try
        {
            FileWriter fw = new FileWriter(output);
            BufferedWriter out = new BufferedWriter(fw);
            StringBuilder text = new StringBuilder();
            HttpURLConnection conn = (HttpURLConnection) page.openConnection();
            conn.connect();
            InputStreamReader in = new InputStreamReader((InputStream) conn.getContent());
            BufferedReader buff = new BufferedReader(in);
            String line;
            do {
                line = buff.readLine();
                if(line!=null)
                {
                    out.write(line, 0, line.length());
                }
            } while (line!=null);
            out.flush();
            out.close();
            System.out.println(output.getName()+" saved");

        } catch (IOException ioe)
        {
            System.out.println("IO Error: "+ioe.getMessage());
        }
    }

    public static void main(String[] args) {
        if(args.length<1)
        {
            System.out.println("Usage: java Webserver url");
            System.exit(1);
        }
        try
        {
            WebSaver app = new WebSaver(args[0]);
            app.getData();
        } catch (MalformedURLException mue)
        {
            System.out.println("Bad URL: "+args[0]);
        }
    }
}
