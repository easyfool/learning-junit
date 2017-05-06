package com.wangfengbabe.learning;

/**
 * Created by wangfeng on 09/02/2017.
 */
public class Book {

  private String name;

  public Book() {
    System.out.println("hello");
    System.out.println();
  }

  public Book(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
