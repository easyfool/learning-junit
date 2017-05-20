package com.wangfengbabe.learning;

/**
 * Created by wangfeng on 12/05/2017.
 */
public interface RequestHandler {

  Response process(Request request) throws Exception;
}
