package com.wangfengbabe.learning;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by wangfeng on 09/02/2017.
 */
public class ExceptionTest {

  @Test(expected = IndexOutOfBoundsException.class)
  public void testEmptyList() {
    new ArrayList<Object>().get(0);
  }

  @Test
  public void testExceptionMessage() {
    try {
      new ArrayList<Object>().get(0);
      fail("Expect an IndexOutOfBoundException to be thrown");
    } catch (IndexOutOfBoundsException exception) {
      assertThat(exception, instanceOf(IndexOutOfBoundsException.class));
      assertThat(exception.getMessage(), containsString("Index: 0"));
    }
  }

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void shouldThrowIndexOutofBoundException() {
    expectedException.expect(IndexOutOfBoundsException.class);
    expectedException.expectMessage("Index: 0, Size: 0");
    new ArrayList<Object>().get(0);
  }
}
