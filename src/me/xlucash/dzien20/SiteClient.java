package me.xlucash.dzien20;

import java.io.*;
import java.net.*;
import java.util.*;
import org.apache.xmlrpc.*;
import org.apache.xmlrpc.client.*;

public class SiteClient {
    public static void main(String[] args) {
        SiteClient client = new SiteClient();
        try
        {
            HashMap<String, String> resp = client.getRandomSite();
            if(resp.size()>0)
            {
                System.out.println("URL: "+resp.get("url")+"\nTytuł: "+resp.get("title")+"\nOpis: "+resp.get("description"));

            }
        } catch (IOException | XmlRpcException ex)
        {
            System.out.println("Wyjątek: "+ex.getMessage());
        }
    }
    public HashMap getRandomSite() throws IOException, XmlRpcException
    {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        URL server = new URL("http://localhost:4413");
        config.setServerURL(server);
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        ArrayList params = new ArrayList();
        HashMap result = (HashMap) client.execute("dmoz.getRandomSite", params);
        return result;
    }
}

