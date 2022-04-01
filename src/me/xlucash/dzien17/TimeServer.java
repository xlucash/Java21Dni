package me.xlucash.dzien17;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TimeServer extends Thread {
    private ServerSocket sock;

    public TimeServer()
    {
        super();
        try
        {
            sock = new ServerSocket(4415);
            System.out.println("Uruchomiono TimeServer...");

        } catch (IOException e)
        {
            System.out.println("Błąd: nie udało się utworzyć gniazda");
            System.exit(1);
        }
    }

    public void run()
    {
        Socket client = null;

        while(true) {
            if(sock==null)
                return;
            try
            {
                client = sock.accept();
                BufferedOutputStream bb = new BufferedOutputStream(client.getOutputStream());
                PrintWriter os = new PrintWriter(bb, false);
                String outLine;
                Date now = new Date();
                os.println(now);
                os.flush();
                os.close();
                client.close();
            } catch (IOException e)
            {
                System.out.println("Błąd: nie udało się połączyć");
                System.exit(1);
            }
        }
    }

    public static void main(String[] args) {
        TimeServer server = new TimeServer();
        server.start();
    }
}
