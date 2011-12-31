package com.kata.basket;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BasketTest {

	@Test
	public void testBasics() {
		assertEquals(0, price(), 0);
		assertEquals(8, price(0), 0);
		assertEquals(8, price(1), 0);
		assertEquals(8, price(2), 0);
		assertEquals(8, price(3), 0);
		assertEquals(8, price(4), 0);
		assertEquals(8 * 2, price(0, 0), 0);
		assertEquals(8 * 3, price(1, 1, 1), 0);
	}

	@Test
	public void testSimpleDiscounts() {
		assertEquals(8 * 2 * 0.95, price(0, 1), 0);
		assertEquals(8 * 3 * 0.9,  price(0, 2, 4), 0);
		assertEquals(8 * 4 * 0.8,  price(0, 1, 2, 4), 0);
		assertEquals(8 * 5 * 0.75, price(0, 1, 2, 3, 4), 0);
	}

	@Test
	 public void testSeveralDiscounts(){
	  assertEquals(8 + (8 * 2 * 0.95), price(0, 0, 1),0);
	  assertEquals(2 * (8 * 2 * 0.95), price(0, 0, 1, 1),0);
	  assertEquals((8 * 4 * 0.8) + (8 * 2 * 0.95), price(0, 0, 1, 2, 2, 3),0);
	  assertEquals(8 + (8 * 5 * 0.75), price(0, 1, 1, 2, 3, 4),0);
	 }
	@Test
	 public  void testEdgeCases(){
	 assertEquals(2 * (8 * 4 * 0.8), price(0, 0, 1, 1, 2, 2, 3, 4),0);
	 assertEquals(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8),
	 price(0, 0, 0, 0, 0,
	        1, 1, 1, 1, 1,
	        2, 2, 2, 2,
	        3, 3, 3, 3, 3,
	        4, 4, 4, 4),0);
	 }

	private double price(int... idBook) {
		List<Integer> itemsBasket = new ArrayList<Integer>();
		for (Integer id : idBook)
			itemsBasket.add(id);
		return new Basket(itemsBasket).total();
	}

}
