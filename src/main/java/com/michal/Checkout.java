package com.michal;

import com.michal.model.Item;

/**
 * Checkout component.
 *
 * <p>Current promotions for items:
 *
 * <p>{@link Item#A} : 3 for 70
 *
 * <p>{@link Item#B} : 2 for 70
 *
 * <p>{@link Item#C} : no promotions
 *
 * <p>{@link Item#D} : no promotions
 */
public class Checkout {
  private static final int A_PROMO_QUANTITY = 3;
  private static final int A_PROMO_PRICE = 70;
  private static final int B_PROMO_QUANTITY = 2;
  private static final int B_PROMO_PRICE = 15;

  /**
   * Calculate prices based in item unit price and quantity.
   *
   * <p>Take into consideration promotions for certain items.
   *
   * @param item      item type
   * @param quantity  quantity of items
   * @return  calculated price
   * @throws IllegalArgumentException if quantity provided is smaller than zero
   */
  public long calculatePrice(Item item, int quantity) {
    if (quantity < 0) {
      throw new IllegalArgumentException("Quantity smaller than zero");
    }
    int count;
    int rest;
    long result = 0;
    switch (item) {
      case A:
        count = quantity / A_PROMO_QUANTITY;
        rest = quantity % A_PROMO_QUANTITY;
        result = (long) count * (long) A_PROMO_PRICE + (long) rest * (long) item.get();
        break;
      case B:
        count = quantity / B_PROMO_QUANTITY;
        rest = quantity % B_PROMO_QUANTITY;
        result = (long) count * (long) B_PROMO_PRICE + (long) rest * (long) item.get();
        break;
      case C:
      case D:
        result = (long) item.get() * (long) quantity;
        break;
      default:
        result = 0;
    }
    return result;
  }
}
