public class Sudoku {
    private int[][] grid;

    public Sudoku(int[][] grid)
    {
        this.grid = grid;
    }
    int[][] getGrid()
    {
        return grid;
    }
    private boolean isValidPosition (int row, int col, int number)
    {
        // check row and column
        int grid_size = 9;
        for (int i = 0; i < grid_size; i++)
        {
            if(grid[row][i] == number || grid[i][col] == number) return false;
        }
        // check sub-square
        int sub_grid_row = row - row % 3;
        int sub_grid_col = col - col % 3;
        for (int i = sub_grid_row; i < sub_grid_row + 3; i++)
        {
            for (int j = sub_grid_col; j < sub_grid_col + 3; j++)
            {
                if (grid[i][j] == number) return false;
            }
        }
        return true;
    }

    public boolean solve()
    {
        int row = 0;
        int col = 0;
        boolean is_not_Empty = true;
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0 ;j < 9 ; j++)
            {
                if(grid[i][j] == 0)
                {
                    row = i; col = j;
                    is_not_Empty = false;
                    break;
                }
            }
            if(!is_not_Empty)
            {
                break;
            }
        }
        if (is_not_Empty) return true;
        for (int i = 1; i < 10; i++)
        {
            if (isValidPosition(row, col, i))
            {
                grid[row][col] = i;
                if (solve()) return true;
                else
                {
                    grid[row][col] = 0;
                }
            }
        }
        return false;
    }
    public static int[][] stringsToGrid(String ... strings)
    {
        int[][] ans = new int[9][9];
        for (int i = 0;i < 9; i++)
        {
            String[] row = strings[i].split(" ");
            for (int j = 0; j < 9; j++)
            {
                ans[i][j] = Integer.parseInt(row[j]);
            }
        }
        return ans;
    }
    @Override
    public String toString()
    {
        StringBuilder strB = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
            {
                strB.append(grid[i][j]);
                strB.append(" ");
            }
            strB.append("\n");
        }
        return strB.toString();
    }
}
