package com.wangfengbabe.learning;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by wangfeng on 17/05/2017.
 */
public class WebClientTest {

  @BeforeClass
  public static void setup() {
    WebClientTest t = new WebClientTest();
    URL.setURLStreamHandlerFactory(t.new StubStreamHandlerFactory());
  }

  private class StubStreamHandlerFactory implements URLStreamHandlerFactory {

    @Override
    public URLStreamHandler createURLStreamHandler(String protocol) {
      return new StubHttpURLStreamHandler();
    }
  }

  private class StubHttpURLStreamHandler extends URLStreamHandler {

    @Override
    protected URLConnection openConnection(URL url) throws IOException {
      return new StubHttpURLConnection(url);
    }
  }

  @Test
  public void testGetContentOk() throws Exception {

    MockConnectionFactory mockConnectionFactory = new MockConnectionFactory();
    mockConnectionFactory.setData(new ByteArrayInputStream("It works".getBytes()));
    WebClient client = new WebClient();
    String result = client.getContent(mockConnectionFactory);
    assertEquals("It works", result);
  }

}