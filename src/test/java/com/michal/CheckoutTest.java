package com.michal;

import com.michal.model.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Checkout component tests")
class CheckoutTest {
  private Checkout checkout;
  @BeforeEach
  void setUp() {
    checkout = new Checkout();
  }

  @AfterEach
  void tearDown() {
    checkout = null;
  }

  @Test
  @DisplayName("Zero calculation")
  void calculatePriceTest0() {
    assertAll(
        () -> assertEquals(0, checkout.calculatePrice(Item.A, 0)),
        () -> assertEquals(0, checkout.calculatePrice(Item.B, 0)),
        () -> assertEquals(0, checkout.calculatePrice(Item.C, 0)),
        () -> assertEquals(0, checkout.calculatePrice(Item.D, 0))
    );
  }

  @Test
  @DisplayName("Simple calculation")
  void calculatePriceTest1() {
    assertAll(
        () -> assertEquals(40, checkout.calculatePrice(Item.A, 1)),
        () -> assertEquals(10, checkout.calculatePrice(Item.B, 1)),
        () -> assertEquals(30, checkout.calculatePrice(Item.C, 1)),
        () -> assertEquals(25, checkout.calculatePrice(Item.D, 1))
    );
  }

  @Test
  @DisplayName("Twice calculation")
  void calculatePriceTest2() {
    assertAll(
        () -> assertEquals(80, checkout.calculatePrice(Item.A, 2)),
        () -> assertEquals(15, checkout.calculatePrice(Item.B, 2)),
        () -> assertEquals(60, checkout.calculatePrice(Item.C, 2)),
        () -> assertEquals(50, checkout.calculatePrice(Item.D, 2))
    );
  }

  @Test
  @DisplayName("Three times calculation")
  void calculatePriceTest3() {
    assertAll(
        () -> assertEquals(70, checkout.calculatePrice(Item.A, 3)),
        () -> assertEquals(25, checkout.calculatePrice(Item.B, 3)),
        () -> assertEquals(90, checkout.calculatePrice(Item.C, 3)),
        () -> assertEquals(75, checkout.calculatePrice(Item.D, 3))
    );
  }

  @Test
  @DisplayName("Big ones")
  void calculatePriceTest4() {
    long expected = (long) Integer.MAX_VALUE * 30;
    assertAll(
        () -> assertEquals(expected, checkout.calculatePrice(Item.C, Integer.MAX_VALUE))
    );
  }

  @Test
  @DisplayName("Smaller than zero")
  void calculatePriceTest5() {
    assertAll(
        () -> assertThrows(IllegalArgumentException.class, () -> checkout.calculatePrice(Item.A, -1))
    );
  }

}