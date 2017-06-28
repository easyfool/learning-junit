package com.wangfengbabe.learning;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

/**
 * Created by wangfeng on 17/06/2017.
 * test method how to verify system.out method
 */

public class SystemOutTest {

  @Rule
  public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

  @Test
  public void testShouldSystemOutProperMessage() {
    System.out.println("hello world");
    assertThat(systemOutRule.getLog(), equalTo("hello world\n"));
  }
}
