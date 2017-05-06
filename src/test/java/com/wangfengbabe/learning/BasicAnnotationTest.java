package com.wangfengbabe.learning;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by wangfeng on 14/03/2017.
 */
public class BasicAnnotationTest {

  @BeforeClass
  public static void runBeforeClass() {
    System.out.println("@BeforeClass - run once before class");
  }

  @AfterClass
  public static void runAfrerClass() {
    System.out.println("@AfterClass - run once after class");
  }

  @Before
  public void runBeforeTestMethod() {
    System.out.println("@Before - run before1 test method");
  }

  @After
  public void runAfterTestMethod() {
    System.out.println("@After - run after test method");
  }

  @Test
  public void test_method_1() {
    System.out.println("@Test - test_method_1");
  }

  @Test
  public void test_method_2() {
    System.out.println("@Test - test_method_2");
  }

}
