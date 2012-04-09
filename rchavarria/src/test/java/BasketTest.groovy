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

	@Test
	public void testSimpleTenPercentDiscount() {
		def discountPrice = 8 * 3 * 0.9
		
		assert discountPrice == basket.price([0,1,2])
		assert discountPrice == basket.price([1,2,3])
		assert discountPrice == basket.price([2,3,4])
	}

	@Test
	public void testSimpleTwentyPercentDiscount() {
		def discountPrice = 8 * 4 * 0.8
		
		assert discountPrice == basket.price([0,1,2,3])
		assert discountPrice == basket.price([1,2,3,4])
	}

	@Test
	public void testSimpleTwentyFivePercentDiscount() {
		def discountPrice = 8 * 5 * 0.75
		
		assert discountPrice == basket.price([0,1,2,3,4])
	}

	@Test
	public void testSeveralDiscounts() {
		assert 8 + (8 * 2 * 0.95) ==  basket.price([0, 0, 1])
		
		assert (2 * (8 * 2 * 0.95) == basket.price([0, 0, 1, 1]))
		
		assert ((8 * 4 * 0.8) + (8 * 2 * 0.95) == basket.price([0, 0, 1, 2, 2, 3]))
		assert (8 + (8 * 5 * 0.75) == basket.price([0, 1, 1, 2, 3, 4]))
	}
    
    @Test
    public void testEdgeCases() {
        assert (2 * (8 * 4 * 0.8)) == basket.price([0, 0, 1, 1, 2, 2, 3, 4])
        
        assert (3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8)) == basket.price([0, 0, 0, 0, 0,
                                                                        1, 1, 1, 1, 1,
                                                                        2, 2, 2, 2,
                                                                        3, 3, 3, 3, 3,
                                                                        4, 4, 4, 4])
    }
}
