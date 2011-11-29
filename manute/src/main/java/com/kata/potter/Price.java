package com.kata.potter;

import java.util.List;

public class Price {

	private List<Integer> bookItems;

	public Price(List<Integer> bookItems) {
		this.bookItems=bookItems;
	}

	public double total() {
		double total=0;
		if(!bookItems.isEmpty())
		  total=Discount.calculateTotal(bookItems);//8*bookItems.size();
		return total;
	}

	

}
