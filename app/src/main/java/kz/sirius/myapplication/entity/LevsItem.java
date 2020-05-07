package kz.sirius.myapplication.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class LevsItem implements Serializable {

    private String ip;

    public LevsItem(String ip) {
        this.ip = ip;
    }
    public String getIp() throws IOException {
        URL url = new URL("https://ipconfig.me/");

        URLConnection con = url.openConnection();
        InputStream is =con.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line = null;

        while ((line = br.readLine()) != null) {
            if(line.contains("<strong id=\"ip_address\">")){
                ip = line.split(">")[1];
            }
        }

        return ip;
    }
}