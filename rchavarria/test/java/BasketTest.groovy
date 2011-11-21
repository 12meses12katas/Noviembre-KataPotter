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

	@Test
	public void testOnlyOneBookPrice() {
		assert 8 == basket.price([0])
		assert 8 == basket.price([1])
		assert 8 == basket.price([2])
		assert 8 == basket.price([3])
		assert 8 == basket.price([4])
	}
}
