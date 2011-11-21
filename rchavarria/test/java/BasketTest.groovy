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

	@Test
	public void testSeveralDifferentBooksPrice() {
		assert 16 == basket.price([0,1])
		assert 16 == basket.price([1,3])
		
		assert 24 == basket.price([1,3,4])
		assert 24 == basket.price([0,2,4])
		
		assert 32 == basket.price([0,1,3,4])
		
		assert 40 == basket.price([0,1,2,3,4])
	}
}
