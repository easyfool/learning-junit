package com.wangfengbabe.learning;

import java.io.InputStream;
import jdk.internal.util.xml.impl.Input;

/**
 * Created by wangfeng on 19/05/2017.
 */
public class MockConnectionFactory implements ConnectionFactory {

  private InputStream inputStream;

  public void setData(InputStream inputStream) {
    this.inputStream = inputStream;
  }

  @Override
  public InputStream getData() throws Exception {
    return this.inputStream;
  }
}
