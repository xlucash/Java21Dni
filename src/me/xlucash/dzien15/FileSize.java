package me.xlucash.dzien15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileSize {
    public static void main(String[] args) {
        try {
            FileInputStream file = new FileInputStream("file.dat");
            boolean eof = false;
            int size = 0;
            while (!eof)
            {
                int input = file.read();
                if (input == -1)
                {
                    eof = true;
                } else
                {
                    size++;
                }
            }
            file.close();
            FileOutputStream outFile = new FileOutputStream("file.dat");
            for(int i = 0;i<size;i++)
            {
                outFile.write((byte) 0);
            }
            outFile.close();
        } catch (IOException exception)
        {
            System.out.println("Błąd -- "+exception.toString());
        }
    }
}
