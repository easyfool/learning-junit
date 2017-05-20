package com.wangfengbabe.learning;

import java.io.InputStream;

/**
 * Created by wangfeng on 19/05/2017.
 */
public interface ConnectionFactory {

  InputStream getData() throws Exception;

}
