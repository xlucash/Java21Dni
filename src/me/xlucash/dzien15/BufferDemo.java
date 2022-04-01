package me.xlucash.dzien15;

import java.io.*;

public class BufferDemo {
    public static void main(String[] args) {
        int start = 0;
        int finish = 255;
        if(args.length>1){
            start = Integer.parseInt(args[0]);
            finish = Integer.parseInt(args[1]);
        } else if (args.length>0)
        {
            start = Integer.parseInt(args[0]);
        }
        ArgStream as = new ArgStream(start, finish);
        System.out.println("\nZapisywanie: ");
        boolean success = as.writeStream();
        System.out.println("\nOdczytywanie: ");
        boolean readSuccess = as.readStream();
    }
}

class ArgStream {
    int start = 0;
    int finish = 255;
    ArgStream(int st, int fin)
    {
        start = st;
        finish = fin;
    }
    boolean writeStream()
    {
        try (FileOutputStream file = new FileOutputStream("liczby.dat"); BufferedOutputStream buff = new BufferedOutputStream(file))
        {
            for(int out = start; out<=finish;out++)
            {
                buff.write(out);
                System.out.print(" "+out);
            }
            buff.close();
            return true;
        } catch (IOException e)
        {
            System.out.println("Wyjątek: "+e.getMessage());
            return false;
        }
    }

    boolean readStream()
    {
        try (FileInputStream file = new FileInputStream("liczby.dat"); BufferedInputStream buff = new BufferedInputStream(file))
        {
            int in;
            do {
                in = buff.read();
                if(in!=-1)
                {
                    System.out.print(" "+in);
                }
            } while (in!=-1);
            System.out.println();
            buff.close();
            return true;
        } catch (IOException e)
        {
            System.out.println("Wyjątek: "+e.getMessage());
            return false;
        }
    }
}
