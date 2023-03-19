// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private class Grid {
		private char[][] grid;
		private int rows;
		private int collumns;
		public Grid (char[][] grid)
		{
			this.grid = grid;
			rows = grid.length;
			collumns = grid[0].length;
		}
	}
	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	private Grid new_grid;
	public CharGrid(char[][] grid)
	{
		new_grid = new Grid(grid);
	}
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		if(new_grid.rows == 0) return 0;
		int left = new_grid.collumns; int right = -1; int down = -1; int up = new_grid.rows;
		for (int i=0;i < new_grid.rows;i++) {
			for (int j = 0; j < new_grid.collumns; j++) {
				if (new_grid.grid[i][j] == ch) {
					if (j < left) {
						left = j;
					}
					if (j > right) {
						right = j;
					}
					if (i < up) {
						up = i;
					}
					if (i > down) {
						down = i;
					}
				}
			}
		}
		if(right == -1) // can't find
		{
			return -1;
		}
		return (right-left+1)*(down-up+1);
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		int count_plus = 0;
		for (int i=2;i<new_grid.rows-2;i++)
		{
			int size_of_plus = 1;
			char begin = new_grid.grid[i][0];
			for (int j=1;j<new_grid.collumns;j++)
			{
				char next = new_grid.grid[i][j];
				if(next == begin) {size_of_plus++;}
				else
				{
					if(check(i,j-(size_of_plus/2)-1,begin,size_of_plus))
					{
						count_plus++;
					}
					begin = next;
					size_of_plus = 1;
				}
			}
			if(check(i, new_grid.collumns-size_of_plus/2 -1,begin,size_of_plus )) {
				count_plus++;
			}
		}
		return count_plus;
	}
	private boolean check(int rows , int cols, char c, int size)
	{
		if(size < 5 || size%2==0) return false;
		int middle = size/2;
		if (rows < middle || rows + middle >= new_grid.rows) return false;
		for (int i=rows - middle;i<= rows + middle;i++)
		{
			if(new_grid.grid[i][cols] != c) return false;
		}
		return true;
	}
}
