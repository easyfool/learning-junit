package com.wangfengbabe.learning;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by wangfeng on 19/05/2017.
 */
public class HttpURLConnectionFactory implements ConnectionFactory {

  private URL url;

  public HttpURLConnectionFactory(URL url) {
    this.url = url;
  }

  @Override
  public InputStream getData() throws Exception {
    HttpURLConnection connection = (HttpURLConnection) this.url.openConnection();
    return connection.getInputStream();
  }
}
