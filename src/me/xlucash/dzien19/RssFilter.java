package me.xlucash.dzien19;

import nu.xom.*;

public class RssFilter {
    public static void main(String[] args) {
        if(args.length<2)
        {
            System.out.println("Użycie: java RssFilter plik tekst");
            System.exit(-1);
        }

        String rssFile = args[0];
        String term = args[1];

        try
        {
            Builder bob = new Builder();
            Document doc = bob.build(rssFile);

            Element rss = doc.getRootElement();

            Attribute rssVersion = rss.getAttribute("version");
            String version = rssVersion.getValue();

            if((version.equals("0.91")) & (doc.getDocType()==null))
            {
                DocType rssDtd = new DocType("rss", "http://my.netscape.com/publish/formats/rss-0.91.dtd");
                doc.insertChild(rssDtd, 0);
            }

            Element channel = rss.getFirstChildElement("channel");
            Element title = channel.getFirstChildElement("title");
            Text titleText = (Text) title.getChild(0);

            titleText.setValue(titleText.getValue()+": Poszukiwanie artykułów o tematyce "+term);

            Elements items = channel.getChildElements("item");
            for(int i = 0; i<items.size(); i++)
            {
                Element item = items.get(i);

                Element iTitle = item.getFirstChildElement("title");

                if(iTitle!=null)
                {
                    Text iTitleText = (Text) iTitle.getChild(0);

                    if(iTitleText.toString().indexOf(term)==-1)
                    {
                        channel.removeChild(item);
                    }
                }
            }

            Serializer output = new Serializer(System.out);
            output.setIndent(2);
            output.write(doc);
        } catch (Exception exc)
        {
            System.out.println("Błąd: "+exc.getMessage());
            exc.printStackTrace();
        }
    }
}
