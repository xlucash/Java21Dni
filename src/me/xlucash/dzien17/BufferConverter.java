package me.xlucash.dzien17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class BufferConverter {
    public static void main(String[] args) {
        try {
            String data = "znajomi.dat";
            FileInputStream inData = new FileInputStream(data);
            FileChannel inChannel = inData.getChannel();
            long inSize = inChannel.size();
            ByteBuffer source = ByteBuffer.allocate((int) inSize);
            inChannel.read(source, 0);
            source.position(0);
            System.out.println("Oryginalne dane bajtowe:");
            for (int i = 0; source.remaining() > 0; i++) {
                System.out.print(source.get() + " ");
            }
            source.position(0);
            Charset ascii = Charset.forName("US-ASCII");
            CharsetDecoder toAscii = ascii.newDecoder();
            CharBuffer destination = toAscii.decode(source);
            destination.position(0);
            System.out.println("\n\nNowe dane znakowe:");
            for (int i = 0; destination.remaining() > 0 ;i++)
            {
                System.out.print(destination.get());
            }
            System.out.println();

        } catch (FileNotFoundException fne)
        {
            System.out.println(fne.getMessage());
        } catch (IOException ioe)
        {
            System.out.println(ioe.getMessage());
        }
    }
}
