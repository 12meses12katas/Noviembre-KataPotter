package katapotter;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static katapotter.Price.price;
import static java.util.Arrays.asList;

public class PriceTest {

    @Test()
    public void noBooksNoMoney() {
        assertEquals(BigDecimal.valueOf(0), price(Collections.<Integer>emptyList()));
    }

    @Test
    public void priceWithoutDiscounts() {
        assertEquals(BigDecimal.valueOf(8), price(asList(0)));
        assertEquals(BigDecimal.valueOf(8), price(asList(1)));
        assertEquals(BigDecimal.valueOf(8), price(asList(2)));
        assertEquals(BigDecimal.valueOf(8), price(asList(3)));
        assertEquals(BigDecimal.valueOf(8), price(asList(4)));
        assertEquals(BigDecimal.valueOf(8 * 2), price(asList(0, 0)));
        assertEquals(BigDecimal.valueOf(8 * 3), price(asList(1, 1, 1)));
    }

    @Test
    public void priceSimpleDiscounts() {
        assertEquals(BigDecimal.valueOf(8 * 2 * 0.95), price(asList(0, 1)));
        /*
  assert_equal(8 * 3 * 0.9, price([0, 2, 4]))
  assert_equal(8 * 4 * 0.8, price([0, 1, 2, 4]))
  assert_equal(8 * 5 * 0.75, price([0, 1, 2, 3, 4]))
        */
    }

}
