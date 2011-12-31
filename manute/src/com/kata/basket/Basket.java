package com.kata.basket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Basket {

	private static final int ZERO = 0;
	private static final int BASE_PRICE = 8;
	private static final double[] DISCOUNTS = { 1, 0.95, 0.9, 0.8, 0.75 };
	private static final double CHEAPER2FOURTHAN3ANDFIVE=0.4;

	private List<Integer> itemsBasket;
	private List<List<Integer>> itemsGroupByDistinctID;

	public Basket(List<Integer> itemsBasket) {
		this.itemsBasket = itemsBasket;
		this.itemsGroupByDistinctID = groupsItemsByID(itemsBasket);

	}

	private List<List<Integer>> groupsItemsByID(List<Integer> itemsBasket) {

		List<List<Integer>> groups = new ArrayList<List<Integer>>();

		for (Integer item : itemsBasket) {

			addItemInGroup(groups, item);
		}

		return groups;
	}

	private void addListInGroup(List<List<Integer>> groups, Integer item) {
		List<Integer> itemsList = new ArrayList<Integer>();
		itemsList.add(item);
		groups.add(itemsList);
	}

	private void addItemInGroup(List<List<Integer>> groups, Integer item) {

		Iterator<List<Integer>> it = groups.iterator();
		int contAdd = 0;
		while (it.hasNext()) {
			List<Integer> itemsList = it.next();
			if (!itemsList.contains(item)) {
				itemsList.add(item);
				contAdd++;
				break;
			}

		}
		if (contAdd == 0) {
			addListInGroup(groups, item);
		}
	}

	public double total() {
		if (!itemsBasket.isEmpty())
			return totalBasketPrice();
		return ZERO;
	}

	private double totalBasketPrice() {
		Iterator<List<Integer>> it = itemsGroupByDistinctID.iterator();
		List<Integer> itemsList = null;
		double total = 0;
		boolean isThree = false, isFive = false;
		while (it.hasNext()) {
			itemsList = it.next();
			int sizeList = itemsList.size();
			total += appliedDiscount(sizeList);
			if (sizeList == 5) {
				isFive = true;
			}
			if (sizeList == 3) {
				isThree = true;
			}
		}
		if (isThree && isFive) {
			total -= CHEAPER2FOURTHAN3ANDFIVE;
		}

		return total;
	}

	private double appliedDiscount(int sizeList) {

		return BASE_PRICE * sizeList * DISCOUNTS[sizeList - 1];
	}

}
