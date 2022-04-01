package me.xlucash.dzien19;

import java.io.*;
import nu.xom.*;

public class DomainWriter {
    public static void main(String[] args) throws IOException {
        try {
            Builder builder = new Builder();
            File xmlFile = new File("feed2.rss");
            Document doc = builder.build(xmlFile);

            Comment timestamp = new Comment("Czas utworzenia pliku: "+new java.util.Date());
            doc.insertChild(timestamp,0);

            FileOutputStream f = new FileOutputStream("feed3.rss");

            Serializer output = new Serializer(f);
            output.setIndent(2);
            output.write(doc);
        } catch (ParsingException pe)
        {
            System.out.println("Błąd przetwarzania: "+pe.getMessage());
            pe.printStackTrace();
            System.exit(-1);
        }
    }
}
