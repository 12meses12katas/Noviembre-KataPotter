import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test


class BookListUtilTest {

	private BookListUtil bookList
	
	@Before
	public void setUp() throws Exception {
		bookList = new BookListUtil()
	}

	@Test
	public void testAllBooksAreDifferent(){
		assert true == bookList.areAllDifferent([])
		assert true == bookList.areAllDifferent([0])
		assert true == bookList.areAllDifferent([0,1])
		assert true == bookList.areAllDifferent([0,1,2])
		assert true == bookList.areAllDifferent([0,1,2,3])
		assert true == bookList.areAllDifferent([0,1,2,3,4])
		
		assert false == bookList.areAllDifferent([0,0])
		assert false == bookList.areAllDifferent([0,1,0])
		assert false == bookList.areAllDifferent([0,1,1])
		assert false == bookList.areAllDifferent([0,1,2,3,0])
		assert false == bookList.areAllDifferent([0,1,2,2,3])
	}
	
}
