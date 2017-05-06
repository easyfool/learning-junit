package com.wangfengbabe.learning;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

/**
 * Created by wangfeng on 09/02/2017.
 */
public class StringListTest {

  @Test
  public void testAssertList() {
    List<String> actual = Arrays.asList("a", "b", "c");
    List<String> expected = Arrays.asList("a", "b", "c");
    //All passed /true

    //1. test equal
    assertThat(actual, is(expected));

    //2. if list has this value
    assertThat(actual, hasItem("b"));

    //3. check list size
    assertThat(actual.size(), is(3));

    //4. list order
    //ensure correct order
    assertThat(actual, contains("a", "b", "c"));
    //can be any order
    assertThat(actual, containsInAnyOrder("a", "b", "c"));

    //5. check empty list
    assertThat(actual, not(IsEmptyCollection.empty()));
    assertThat(new ArrayList<String>(), IsEmptyCollection.empty());

  }
}
