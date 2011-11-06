package katapotter;

import org.junit.Test;

import java.util.Arrays;

public class PriceTest {

    @Test()
    public void noBooksNoMoney() {
        assertEquals(0, Price.price(Arrays.asList()));
    }
}
