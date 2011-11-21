import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


class BasketTest {

	private basket
	
	@Before
	public void setUp() throws Exception {
		basket = new Basket()
	}

	@Test
	public void testNoBooksPrice() {
		assert 0 == basket.price([])
	}
}
