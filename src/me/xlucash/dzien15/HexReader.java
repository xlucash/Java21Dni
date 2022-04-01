package me.xlucash.dzien15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HexReader {

    public HexReader()
    {
        FileReader file;
        try
        {
            file = new FileReader("hexfile.txt");
            BufferedReader buff = new BufferedReader(file);

            boolean eof = false;
            while(!eof)
            {
                String line = buff.readLine();
                if(line==null)
                {
                    eof = true;
                } else
                {
                    readLine(line);
                }
            }
            buff.close();
        } catch (IOException ex)
        {
            System.out.println("Błąd wejścia-wyjścia "+ex.getMessage());
        }
    }

    private void readLine(String code){
        try
        {
            for(int j = 0;j+1<code.length();j+=2)
            {
                String sub = code.substring(j,j+2);
                int num = Integer.parseInt(sub,16);
                if(num==255)
                {
                    return;
                }
                System.out.print(num + " ");
            }
        } finally {
            System.out.println("**");
        }
    }

    public static void main(String[] args) {
        new HexReader();
    }
}
