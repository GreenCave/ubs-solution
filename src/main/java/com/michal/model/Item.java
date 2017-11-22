package com.michal.model;

/**
 * Item enum with prices.
 */
public enum Item {
  /**
   * {@link Item#A} : 40
   */
  A(40),
  /**
   * {@link Item#B} : 10
   */
  B(10),
  /**
   * {@link Item#C} : 30
   */
  C(30),
  /**
   * {@link Item#D} : 25
   */
  D(25);

  private int price;

  Item(int price) {
    this.price = price;
  }

  /**
   * Get Item enum value.
   * @return  value of item
   */
  public int get() {
    return price;
  }
}
