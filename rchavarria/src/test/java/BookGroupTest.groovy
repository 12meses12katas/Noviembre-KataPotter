import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


class BookGroupTest {

	private group
	
	@Before
	public void setUp() throws Exception {
		group = new BookGroup()
	}

	@Test
	public void testComputeEmptyBookList() {
		assert [] == group.compute([])
	}

	@Test
	public void testComputeAllBooksDifferentBookList() {
		assert [[0]] == group.compute([0])
		assert [[0,1,2]] == group.compute([0,1,2])
		assert [[0,1,2,3,4]] == group.compute([0,1,2,3,4])
	}

	@Test
	public void testComputeBookList() {
		assert [[0],[0]] == group.compute([0,0])
		
		assert [[0,1],[0]] == group.compute([0,1,0])
		assert [[0,1],[0]] == group.compute([0,0,1])
		
		assert [[0,1],[0,1]] == group.compute([0,0,1,1])
		assert [[0,1],[0,1]] == group.compute([0,1,0,1])
		
		assert [[0,1,2,3],[0,2]] == group.compute([0,0,1,2,2,3])
		
		assert [[0,1,2,3,4],[1]] == group.compute([0,1,1,2,3,4])
	}
}
