package com.kata.potter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PriceTest {

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
		assertEquals(8 * 3 * 0.9, price(0, 2, 4), 0);
		assertEquals(8 * 4 * 0.8, price(0, 1, 2, 4), 0);
		assertEquals(8 * 5 * 0.75, price(0, 1, 2, 3, 4), 0);
	}

	private double price(int... items) {
		List<Integer> bookItems = new ArrayList<Integer>();
		for (int bookItem : items) {
			bookItems.add(bookItem);
		}
		return new Price(bookItems).total();
	}
}
