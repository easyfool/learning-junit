package com.wangfengbabe.learning;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.hamcrest.core.IsSame;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by wangfeng on 12/05/2017.
 */


public class DefaultControllerTest {

  private DefaultController controller;
  private Request request;
  private RequestHandler handler;

  private class SampleRequest implements Request {

    private static final String DEFAULT_NAME = "Test";
    private String name;

    public SampleRequest() {
      this.name = DEFAULT_NAME;
    }

    public SampleRequest(String name) {
      this.name = name;
    }

    public String getName() {
      return this.name;
    }
  }

  private class SampleExceptiontHandler implements RequestHandler {


    @Override
    public Response process(Request request) throws Exception {
      throw new Exception("error  processing request");
    }
  }

  private class SampleResponse implements Response {

    private static final String NAME = "Test";

    public String getName() {
      return NAME;
    }

    public boolean equals(Object object) {
      boolean result = false;
      if (object instanceof SampleResponse) {
        result = (((SampleResponse) object).getName()).equals(getName());
      }
      return result;

    }

    public int hashCode() {
      return NAME.hashCode();
    }


  }


  private class SampleHandler implements RequestHandler {

    @Override
    public Response process(Request request) throws Exception {
      return new SampleResponse();
    }
  }

  @Before
  public void setUp() throws Exception {
    controller = new DefaultController();
    request = new SampleRequest();
    handler = new SampleHandler();
    controller.addHandler(request, handler);
  }

  @Test
  public void testAddHandler() {

    RequestHandler handler2 = controller.getHandler(request);
    assertThat("handler2 and handler should be the same instance", handler2, IsSame.sameInstance(handler));

  }

  @Test
  public void testProcessRequest() {
    Response response = controller.processRequest(request);
    assertThat(response, notNullValue());
    assertThat("response should be type of SampleResponse", response.getClass(), equalTo(SampleResponse.class));
    assertThat(response, equalTo(new SampleResponse()));
  }

  @Test
  public void testProcessRequestAnswersErrorResponse() {
    SampleRequest request = new SampleRequest("testError");
    SampleExceptiontHandler handler = new SampleExceptiontHandler();
    controller.addHandler(request, handler);
    Response response = controller.processRequest(request);
    assertThat(response, notNullValue());
    assertThat(response.getClass(), equalTo(ErrorResponse.class));
  }

  @Test(expected = RuntimeException.class)
  public void testGetHandlerNotDefined() {
    SampleRequest request = new SampleRequest("testNotDefined");
    controller.getHandler(request);
  }

  @Test(expected = RuntimeException.class)
  public void testAddDuplicateHandler() {
    SampleRequest request = new SampleRequest();
    SampleHandler handler = new SampleHandler();
    controller.addHandler(request, handler);
  }

  @Test(timeout = 130)
  public void testProcessMultipleRequestsTimeout() {
    Request request;
    Response response = new SampleResponse();
    RequestHandler handler = new SampleHandler();
    for (int i = 0; i < 99999; i++) {
      request = new SampleRequest(String.valueOf(i));
      controller.addHandler(request, handler);
      response = controller.processRequest(request);
      assertThat(response, notNullValue());
      assertThat(response.getClass(), not(equalTo(ErrorResponse.class)));

    }
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void getHandler() throws Exception {
  }

  @Test
  public void processRequest() throws Exception {

  }

  @Test
  public void addHandler() throws Exception {
  }

}