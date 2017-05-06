package com.wangfengbabe.learning;

/**
 * Created by wangfeng on 09/02/2017.
 */
public class Fruit {

  private String name;
  private int quantity;

  public Fruit(String name, int quantity) {
    this.name = name;
    this.quantity = quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Fruit fruit = (Fruit) o;

    if (quantity != fruit.quantity) {
      return false;
    }
    return name.equals(fruit.name);
  }

  @Override
  public int hashCode() {
    int result = name.hashCode();
    result = 31 * result + quantity;
    return result;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
