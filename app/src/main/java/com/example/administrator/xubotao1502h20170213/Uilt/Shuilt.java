package com.example.administrator.xubotao1502h20170213.Uilt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2017/2/13.
 */

public class Shuilt {
    public  static String shUilt(InputStream inputStream) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer stringBuffer = new StringBuffer();
        String str;
        while((str=br.readLine())!=null)
        {
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }
}
