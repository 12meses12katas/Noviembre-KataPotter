package com.kata.potter;

import java.util.HashSet;
import java.util.List;

public class Discount {
	
	private static final int BASE = 8;
	private static final double[] DISCOUNT={1,0.95,0.9,0.8,0.75};

	public static double calculateTotal(List<Integer> bookItems) {
		HashSet<Integer> noDuplicatesItems=new HashSet<Integer>(bookItems);
		return restDiscount(bookItems, noDuplicatesItems);
	}

	private static double restDiscount(List<Integer> bookItems,
			HashSet<Integer> noDuplicatesItems) {
		return BASE * bookItems.size()* DISCOUNT[noDuplicatesItems.size()-1];
	}

}
