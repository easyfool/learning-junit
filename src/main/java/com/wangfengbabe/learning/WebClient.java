package com.wangfengbabe.learning;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by wangfeng on 17/05/2017.
 */
public class WebClient {

  public String getContent(ConnectionFactory connectionFactory) throws Exception {

    StringBuffer content = new StringBuffer();
    try {
      InputStream is = connectionFactory.getData();

//      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//      connection.setDoInput(true);
//      InputStream is = connection.getInputStream();

//      byte[] buffer = new byte[1024 * 2];
      int count;
      while (-1 != (count = is.read())) {
        content.append(new String(Character.toChars(count)));
      }


    } catch (IOException e) {

      return null;
    }

    return content.toString();

  }
}
