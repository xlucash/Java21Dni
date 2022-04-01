package me.xlucash.dzien19;

import java.io.*;
import nu.xom.*;

public class DomainEditor {
    public static void main(String[] args) throws IOException {
        try
        {
            Builder builder = new Builder();
            File xmlFile = new File("feed.rss");
            Document doc = builder.build(xmlFile);

            Element root = doc.getRootElement();

            Element channel = root.getFirstChildElement("channel");

            Elements children = channel.getChildElements();
            for(int i = 0;i<children.size(); i++)
            {
                Element link = children.get(i);
                Text linkText = (Text) link.getChild(0);

                if(linkText.getValue().equals("http://workbench.cadenhead.org/"))
                {
                    link.removeChild(0);
                    link.appendChild("http://www.cadenhead.org/");
                }
            }

            Element item = new Element("item");
            Element itemTitle = new Element("title");
            itemTitle.appendChild("Uwolnić wszystkie periodyki");

            item.appendChild(itemTitle);
            channel.appendChild(item);

            try (FileWriter fw = new FileWriter("feed2.rss"); BufferedWriter out = new BufferedWriter(fw))
            {
                out.write(doc.toXML());
            } catch (IOException ioe)
            {
                System.out.println(ioe.getMessage());
            }
        } catch (ParsingException pe)
        {
            System.out.println("Błąd przetwarzania: "+pe.getMessage());
            pe.printStackTrace();
            System.exit(-1);
        }
    }
}
