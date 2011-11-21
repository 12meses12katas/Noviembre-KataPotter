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
	public void testSeveralSameBooksPrice() {
		assert 16 == basket.price([0,0])
		assert 16 == basket.price([1,1])
		assert 24 == basket.price([1,1,1])
	}

	@Test
	public void testSimpleFivePercentDiscount() {
		def discountPrice = 8 * 2 * 0.95
		
		assert discountPrice == basket.price([0,1])
		assert discountPrice == basket.price([1,2])
		assert discountPrice == basket.price([2,3])
		assert discountPrice == basket.price([3,4])
	}
}
