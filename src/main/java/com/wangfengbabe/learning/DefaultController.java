package com.wangfengbabe.learning;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangfeng on 12/05/2017.
 */
public class DefaultController implements Controller {

  private Map<String, RequestHandler> requestHanlders = new HashMap<String, RequestHandler>();

  protected RequestHandler getHandler(Request request) {
    if (!this.requestHanlders.containsKey(request.getName())) {
      String message = "Cannot find handler for request name [" + request.getName() + "]";
      throw new RuntimeException(message);
    }
    return this.requestHanlders.get(request.getName());

  }

  @Override
  public Response processRequest(Request request) {
    Response response;
    try {
      response = getHandler(request).process(request);
    } catch (Exception e) {
      response = new ErrorResponse(request, e);
    }
    return response;
  }

  @Override
  public void addHandler(Request request, RequestHandler requestHandler) {
    if (this.requestHanlders.containsKey(request.getName())) {
      throw new RuntimeException(
          "A request handler has already been registered  for request name [" + request.getName() + "]");
    } else {
      this.requestHanlders.put(request.getName(), requestHandler);
    }
  }
}
