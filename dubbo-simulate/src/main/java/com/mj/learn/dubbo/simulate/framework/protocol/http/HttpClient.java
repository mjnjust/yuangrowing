package com.mj.learn.dubbo.simulate.framework.protocol.http;

import com.mj.learn.dubbo.simulate.framework.invoke.Invocation;
import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.scan.UrlJar;

import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpClient {
    public void send(String hostname, Integer port, Invocation invocation) {
        try {
            URL url = new URL("http", hostname, port, "/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(invocation);
            objectOutputStream.flush();
            objectOutputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            System.out.println(IOUtils.toString(inputStream));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
