package katapotter;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PriceTest {

    @Test()
    public void noBooksNoMoney() {
        assertEquals(BigDecimal.valueOf(0), Price.price(Arrays.asList()));
    }


}
