package me.xlucash.dzien20;

import java.io.*;
import java.net.*;
import java.util.*;
import org.apache.xmlrpc.*;
import org.apache.xmlrpc.client.*;

public class WordPressClient {
    XmlRpcClient client;

    public WordPressClient() {
        this("https://wordpress.com/xmlrpc.php");
    }

    public WordPressClient(String serverUrl) {
        try {
            // create the client
            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            URL server = new URL(serverUrl);
            config.setServerURL(server);
            client = new XmlRpcClient();
            client.setConfig(config);
        } catch (MalformedURLException exception) {
            System.out.println("Bad URL: " + serverUrl);
        }
    }

    public Object[] getMethods() throws IOException, XmlRpcException {
        ArrayList<Object> params = new ArrayList<>();
        Object[] result = (Object[]) client.execute("system.listMethods", params);
        return result;
    }

    public static void main(String[] arguments) {
        try {
            WordPressClient word;
            word = new WordPressClient();
            Object[] response = word.getMethods();
            for (Object method : response) {
                System.out.println(method);
            }
        } catch (IOException | XmlRpcException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
