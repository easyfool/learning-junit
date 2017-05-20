package com.wangfengbabe.learning;

/**
 * Created by wangfeng on 12/05/2017.
 */
public interface Controller {

  Response processRequest(Request request);

  void addHandler(Request request, RequestHandler requestHandler);

}
