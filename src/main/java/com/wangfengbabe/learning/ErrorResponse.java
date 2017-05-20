package com.wangfengbabe.learning;

/**
 * Created by wangfeng on 12/05/2017.
 */
public class ErrorResponse implements Response {

  private Request orginalRequest;
  private Exception originalException;

  public ErrorResponse(Request orginalRequest, Exception originalException) {
    this.orginalRequest = orginalRequest;
    this.originalException = originalException;
  }

  public Request getOrginalRequest() {
    return orginalRequest;
  }

  public Exception getOriginalException() {
    return originalException;
  }
}
