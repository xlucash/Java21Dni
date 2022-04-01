package me.xlucash.dzien19;

import java.io.*;
import nu.xom.*;

public class RssStarter {
    public static void main(String[] args) {
        Element rss = new Element("rss");
        Attribute version = new Attribute("version","2.0");
        rss.addAttribute(version);
        Element channel = new Element("channel");
        rss.appendChild(channel);
        Element title = new Element("title");
        Text titleText = new Text("Workbench");
        title.appendChild(titleText);
        channel.appendChild(title);

        Element link = new Element("link");
        Text lText = new Text("http://workbench.cadenhead.org/");
        link.appendChild(lText);
        channel.appendChild(link);

        Document doc = new Document(rss);

        try (
            FileWriter fw = new FileWriter("feed.rss");
            BufferedWriter out = new BufferedWriter(fw)
        ) {
            out.write(doc.toXML());
        } catch (IOException ioe)
        {
            System.out.println(ioe.getMessage());
        }
        System.out.println(doc.toXML());
    }
}
