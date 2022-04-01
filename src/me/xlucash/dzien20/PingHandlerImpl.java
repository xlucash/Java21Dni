package me.xlucash.dzien20;

import java.util.*;

public class PingHandlerImpl implements PingHandler {
    public HashMap ping(String siteName, String url) {
        HashMap<String, Object> response = new HashMap<>();
        if ((siteName.equals("")) | (url.equals(""))) {
            response.put("message", "Zły ping");
            boolean flError = true;
            response.put("flerror", flError);
        } else {
            response.put("message", "Dziękuję za ping");
            boolean flError = false;
            response.put("flerror", flError);
            System.out.println("Ping otrzymany z " + siteName + ", " + url);
        }
        return response;
    }
}

