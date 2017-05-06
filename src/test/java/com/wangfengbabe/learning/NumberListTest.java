package com.wangfengbabe.learning;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;


/**
 * Created by wangfeng on 09/02/2017.
 */
public class NumberListTest {

  @Test
  public void testAssertList() {
    List<Integer> actual = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
    //All passed /true

    //1. test equal
    assertThat(actual, is(expected));

    //2. if list has this value
    assertThat(actual, hasItem(4));

    //3. check list size
    assertThat(actual.size(), is(5));

    //4. list order
    //ensure correct order
    //assertThat(actual,containsInAnyOder("a","b","c"));

    //5. check empty list
//        assertThat(actual,not(isEmptyCollection.empty()));

    //6. test numeric comparisions
    assertThat(actual, everyItem(greaterThanOrEqualTo(1)));
    assertThat(actual, everyItem(lessThanOrEqualTo(5)));

  }
}
