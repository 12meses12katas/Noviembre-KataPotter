package katapotter;

import java.math.BigDecimal;
import java.util.*;

public class Price {

    public static double price(List<Integer> books) {
        Purchase purchase = new Purchase();
        for (int book: books)
            purchase.add(book);
        return purchase.price();
    }

    public static class Purchase {
        List<DiscountPack> packs = new LinkedList<DiscountPack>();

        public void add(int book) {
            DiscountPack cheapestPack = null;
            Double smallestPriceIncrement = null;

            for (DiscountPack pack: packs)
                if (pack.accepts(book)) {
                    double priceIncrement = pack.priceIncrement();
                    if (cheapestPack == null || priceIncrement < smallestPriceIncrement) {
                        cheapestPack = pack;
                        smallestPriceIncrement = priceIncrement;
                    }
                }

            if (cheapestPack == null) {
                cheapestPack = new DiscountPack();
                packs.add(cheapestPack);
            }
            cheapestPack.add(book);
        }

        public double price() {
            double totalPrice = 0;
            for (DiscountPack pack: packs)
                totalPrice += pack.price();
            return totalPrice;
        }
    }

    public static class DiscountPack {
        private static final double UNIT_PRICE = 8;
        private static final double[] DISCOUNT_RATES = new double[] { 0, 0, 0.05, 0.1, 0.2, 0.25 };

        private Set<Integer> books;

        public DiscountPack() {
            this.books = new HashSet<Integer>();
        }

        public boolean accepts(int book) {
            return !books.contains(book);
        }

        public double priceIncrement() {
            return price(books.size() + 1) - price(books.size());
        }

        public double price() {
            return price(books.size());
        }

        private static double price(int packSize) {
            double discountRate = DISCOUNT_RATES[packSize];
            return UNIT_PRICE * packSize * (1 - discountRate);
        }

        public void add(int book) {
            this.books.add(book);
        }
    }
}
