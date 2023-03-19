//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
	private class Grid {
		private boolean[][] grid;
		private int rows;
		private int collumns;
		public Grid (boolean[][] grid)
		{
			this.grid = grid;
			rows = grid.length;
			collumns = (rows==0) ? 0 : grid[0].length;
		}
	}
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	private Grid new_grid;
	public TetrisGrid(boolean[][] grid) {
		new_grid = new Grid(grid);
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		int res;
		res = 0;
		for (int i = 0; i < new_grid.collumns; i++) {
				if(!Check_Row(i)){
					if(res != i) Copy_Rows(res,i);
					res++;
			}
		}
		for (int i = res;i<new_grid.collumns;i++)
		{
			Copy_Rows(i,new_grid.collumns);
		}

	}
	private void Copy_Rows(int node, int height)
	{
		for (int i=0;i<new_grid.rows;i++)
		{
			new_grid.grid[i][node] = (height < new_grid.collumns) ? new_grid.grid[i][height] : false;
		}
	}
	private boolean Check_Row(int col)
	{
		for (int i=0;i< new_grid.rows;i++)
		{
			if(!new_grid.grid[i][col]) return false;
		}
		return true;
	}
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return new_grid.grid;
	}
}
