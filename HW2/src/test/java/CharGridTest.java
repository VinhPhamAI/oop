// Test cases for CharGrid -- a few basic tests are provided.

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class CharGridTest {
	@Test
	public void testCharArea1() {
		char[][] grid = new char[][] {
				{'a', 'y', ' '},
				{'x', 'a', 'z'},
			};

		CharGrid cg = new CharGrid(grid);
				
		assertEquals(4, cg.charArea('a'));
		assertEquals(1, cg.charArea('z'));
		assertEquals(1, cg.charArea(' '));
	}
	
	@Test
	public void testCharArea2() {
		char[][] grid = new char[][] {
				{'c', 'a', ' '},
				{'b', ' ', 'b'},
				{' ', ' ', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(6, cg.charArea('a'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
		assertEquals(9, cg.charArea(' '));
		assertEquals(-1,cg.charArea('z'));
	}
	@Test
	public void test_Special_CharArea()
	{
		char[][] grid = new char[][]{
				{'a','a','b',' ',' ','1'},
				{'a','z',' ','w','z','+'},
				{'1','+','z','w',' ',' '}
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(18,cg.charArea('1'));
		assertEquals(8,cg.charArea('z'));
		assertEquals(2,cg.charArea('w'));
	}

	@Test
	public void test_Plus2() {
		char[][] grid = new char[][] {
				{' ', ' ', 'a', ' ', ' ', } ,
				{' ', ' ', 'a', ' ', ' ', } ,
				{'a', 'a', 'a', 'a', 'a', } ,
				{' ', ' ', 'a', ' ', ' ', } ,
				{' ', ' ', 'a', ' ', ' '} ,
		};

		CharGrid cg = new CharGrid(grid);
		assertEquals(1, cg.countPlus());
	}
	@Test
	public void test_Plus3() {
		char[][] grid = new char[][] {
				{' ', 'b', 'c', 'c', 'c', 'c', 'a', },
				{' ', 'b', 'c', 'd', 'c', 'f', 'g', },
				{'a', 'a', 'a', 'd', 'c', 'f', 'c', },
				{'a', 'd', 'd', 'd', 'd', 'd', 'g', },
				{' ', 'b', 'c', 'd', 'e', 'f', 'f', },
				{'a', 'b', 'c', 'd', 'e', 'f', 'f', },
				{'a', 'b', 'c', 'h', 'e', 'f', 'g', },
				{'a', 'b', 'c', 'h', 'g', 'g', ' ', },
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(1, cg.countPlus());
	}
	@Test
	public void test_Plus6() {
		char[][] grid = new char[][] {
				{'1','2','3','4','5','6','7','8','9','0','a','b', },
				{'1','2','3','4','5','6','7','8','9','0','a','b', },
				{'3','3','3','3','3','6','0','0','0','0','0','0', },
				{'1','2','3','4','5','6','7','8','x','0','a','b', },
				{'1','2','3','4','5','6','7','8','9','0','a','b', },
				{'2','2','2','2','5','6','7','8','9','0','a','b', },
				{'1','2','3','4','5','6','7','8','9','k','a','b', },
				{'1','2','3','4','5','9','9','9','9','9','9','9', },
				{'3','3','3','3','3','3','7','8','9','0','a','b', },
				{'1','2','3','4','5','6','7','8','9','0','a','b', },
				{'1','2','3','4','5','6','7','8','9','0','a','b', },
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(2, cg.countPlus());
	}
	@Test
	public void test_Plus4() {
		char[][] grid = new char[][] {
				{'a', ' ', 'a'},
				{' ', 'a', ' '},
				{'a', ' ', 'a'},
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(0, cg.countPlus());
	}
	@Test
	public void test_Plus5() {
		char[][] grid = new char[][] {
				{' ', 'b', 'c', 'c', 'c', 'c', 'a'},
				{' ', 'b', 'c', 'd', 'c', 'f', 'g'},
				{'a', 'a', 'a', 'd', 'c', 'f', 'c'},
				{'a', 'd', 'd', 'd', 'd', 'd', 'g'},
				{' ', 'b', 'c', 'd', 'e', 'f', 'f'},
				{'a', 'b', 'c', 'd', 'e', 'f', 'f'},
				{'a', 'b', 'c', 'h', 'e', 'f', 'g'},
				{'a', 'b', 'c', 'h', 'g', 'g', ' '},
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(1, cg.countPlus());
	}
	@Test
	public void test_Plus7() {
		char[][] grid = new char[][] {
				{' ', ' ', 'a', ' ', ' '},
				{' ', 'a', 'a', 'a', ' '},
				{'a', 'a', 'b', 'a', 'a'},
				{' ', 'a', 'a', 'a', ' '},
				{' ', ' ', 'a', ' ', ' '},
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(0, cg.countPlus());
	}
	@Test
	public void test_Plus8() {
		char[][] grid = new char[][] {
				{' ', 'a', ' '}
,				{'a', 'a', 'a'},
				{' ', 'a', ' '},
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(0, cg.countPlus());
	}
}
