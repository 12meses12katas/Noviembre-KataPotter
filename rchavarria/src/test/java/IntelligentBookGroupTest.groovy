import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

class IntelligentBookGroupTest {

	private group
	
	@Before
	public void setUp() throws Exception {
		group = new IntelligentBookGroup()
	}

	@Test
	public void testEdgeCases() {
        assert [[0,1,2,3],[0,1,2,4]] == group.compute([0, 0, 1, 1, 2, 2, 3, 4])
        
        assert [
            [0,1,2,3,4],
            [0,1,2,3,4],
            [0,1,2,3,4],
            [0,1,2,3],
            [0,1,3,4]] == group.compute([0, 0, 0, 0, 0,
                                        1, 1, 1, 1, 1,
                                        2, 2, 2, 2,
                                        3, 3, 3, 3, 3,
                                        4, 4, 4, 4])
	}
}
