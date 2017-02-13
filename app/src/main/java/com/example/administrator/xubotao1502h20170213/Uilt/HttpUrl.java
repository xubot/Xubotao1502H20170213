package com.example.administrator.xubotao1502h20170213.Uilt;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2017/2/13.
 */

public class HttpUrl {

    private static String vaule;

    public static String httpUrl(String path)
    {
        try {
            URL url = new URL(path);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            if(urlConnection.getResponseCode()==200)
            {
                InputStream inputStream = urlConnection.getInputStream();
                vaule = Shuilt.shUilt(inputStream);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vaule;
    }
}
