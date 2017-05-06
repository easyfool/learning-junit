package com.wangfengbabe.learning;

import org.hamcrest.beans.HasProperty;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

/**
 * Created by wangfeng on 09/02/2017.
 */
public class ClassPropertyTest {

  //Single object
  @Test
  public void testClassProperty() {
    Book book = new Book("Myyong in action");
    assertThat(book, hasProperty("name"));
    assertThat(book, hasProperty("name", is("Myyong in action")));
  }

  //list objects
  @Test
  public void testClassPropertyInList() {
    List<Book> books = Arrays.asList(new Book("Myyong in action"), new
        Book("java in action"));
    assertThat(books, containsInAnyOrder(
        hasProperty("name", is("Myyong in action")),
        hasProperty("name", is("java in " + "action"))));
  }
}
