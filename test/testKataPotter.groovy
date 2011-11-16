import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class testKataPotter {

	int BOOK_PRICE = 8
	
	Basket basket
	
	@Before
	void setUp() {		
		basket = new Basket()
	}
	
	@Test
	void NoBooksPriceTest() {
		assertEquals(0, basket.result)
	}
	
	@Test
	void NoDiscountBooksPriceTest() {
		5.times {
			basket << BookFactory.firstBook()
			assertEquals(BOOK_PRICE * basket.books.size(), basket.result)			
		}
	}
	
	@Test
	void FirstDiscountTest() {
		basket << [BookFactory.firstBook(), BookFactory.secondBook()] * 2
		assertEquals(BOOK_PRICE * basket.books.size() * 0.95, basket.result, 1)
	}
	
	@Test
	void ManyDiscountsTest() {
		basket << [BookFactory.firstBook(), BookFactory.secondBook(), BookFactory.thirdBook()] * 2
		basket << [BookFactory.firstBook(), BookFactory.secondBook()] * 2
		def result = BOOK_PRICE * 4 * 0.95
		result += BOOK_PRICE * 6 * 0.90
		assertEquals(result, basket.result, 1)
	}
	
	@Test
	void EdgeCases() {
		basket << [BookFactory.firstBook(), BookFactory.secondBook(), BookFactory.thirdBook()] * 2
		basket << [BookFactory.fourthBook(), BookFactory.fifthBook()]
		assertEquals(2 * (8 * 4 * 0.8), basket.result, 1)
	}
	
	@Test 
	void MoreEdgeCases() {		
		basket << [BookFactory.firstBook()] * 5
		basket << [BookFactory.secondBook()] * 5
		basket << [BookFactory.thirdBook()] * 4
		basket << [BookFactory.fourthBook()] * 5
		basket << [BookFactory.fifthBook()] * 4
		assertEquals(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8), basket.result, 1)
	}
}
