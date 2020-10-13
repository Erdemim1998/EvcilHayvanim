package com.example.evcilhayvanim;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadUrl {
    public String readUrl(String myUrl) throws IOException{
        String data="";
        InputStream inputStream=null;
        HttpURLConnection httpURLConnection=null;
        try {
            URL url=new URL(myUrl);
            httpURLConnection= (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            inputStream=httpURLConnection.getInputStream();//input stream ile boru aracılığıyla sunucudaki verilere erişilir.
            BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));//Buffered Reader ise verileri satır satır okumamızı sağlar.
            StringBuilder sb=new StringBuilder();
            String line;
            while ((line=br.readLine())!=null){
                sb.append(line);
            }
            data=sb.toString();
            br.close();
        } catch (MalformedURLException e) {
            Log.i("DownloadUrl","readUrl:"+e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            assert inputStream != null;
            inputStream.close();
            httpURLConnection.disconnect();
        }
        return data;
    }
}