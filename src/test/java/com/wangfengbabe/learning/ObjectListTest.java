package com.wangfengbabe.learning;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by wangfeng on 09/02/2017.
 */
public class ObjectListTest {

  @Test
  public void testObjectList() {
    List<Fruit> list = Arrays.asList(new Fruit("Banana", 99), new Fruit("Apple", 10));
    // test equals
    assertThat(list, hasItems(new Fruit("Banana", 99), new Fruit("Apple", 10)));

  }
}
