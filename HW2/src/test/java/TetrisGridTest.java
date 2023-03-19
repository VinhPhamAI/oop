import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;

public class TetrisGridTest {
	
	// Provided simple clearRows() test
	// width 2, height 3 grid
	@Test
	public void testClear1() {
		boolean[][] before =
		{	
			{true, true, false, },
			{false, true, true, }
		};
		
		boolean[][] after =
		{	
			{true, false, false},
			{false, true, false}
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	@Test
	public void testClear2() {
		boolean[][] before =
				{
						{true, true, false, },
						{true, true, true, },
						{true, true, true}
				};

		boolean[][] after =
				{
						{false, false, false},
						{true, false, false},
						{true, false, false}
				};

		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	@Test
	public void testClear_hard() {
		boolean[][] before = {
				{true, true, false, false, true, true,true },
				{true, false, true, true, true, false,true },
				{true, true, false, false, true, true,true }
		};
		boolean[][] after = {
				{true, false, false, true, false, false,false },
				{false, true, true, false, false, false,false },
				{true, false, false, true, false, false, false }
		};

		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();
		assertTrue(Arrays.deepEquals(after,  tetris.getGrid()));

	}

	@Test
	public void testClear_Special() {
		boolean[][] before = {
				{true, true, },
				{true, true, },
				{true, true }
		};
		boolean[][] after = {
				{false, false, },
				{false, false, },
				{false, false }
		};

		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();
		assertTrue(Arrays.deepEquals(after,  tetris.getGrid()));
	}

	@Test
	public void testClear4() {
		boolean [][] before = {
				{false, false, true, },
				{true, true, true, },
				{true, false, false }
		};

		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();
		assertTrue(Arrays.deepEquals(before,  tetris.getGrid()));

	}

	@Test
	public void testClear_Empty() {
		boolean[][] before = new boolean[0][0];

		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();
		assertTrue(Arrays.deepEquals(before,  tetris.getGrid()));
	}


}
