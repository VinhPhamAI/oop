import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestSudoku {

    @Test
    public void testSolveValid() throws Exception {
        int[][] grid = Sudoku.stringsToGrid(
                "0 2 0 6 0 8 0 0 0",
                "5 8 0 0 0 9 7 0 0",
                "0 0 0 0 4 0 0 0 0",
                "3 7 0 0 0 0 5 0 0",
                "6 0 0 0 0 0 0 0 4",
                "0 0 8 0 0 0 0 1 3",
                "0 0 0 0 2 0 0 0 0",
                "0 0 9 8 0 0 0 3 6",
                "0 0 0 3 0 6 0 9 0"
        );
        Sudoku sudoku = new Sudoku(grid);
        assertTrue(sudoku.solve());
    }
    @Test
    void testStringsToGrid() throws IOException {
        int[][] expected = {
                {3, 7, 0, 0, 0, 0, 0, 8, 0},
                {0, 0, 1, 0, 9, 3, 0, 0, 0},
                {0, 4, 0, 7, 8, 0, 0, 0, 3},
                {0, 9, 3, 8, 0, 0, 0, 1, 2},
                {0, 0, 0, 0, 4, 0, 0, 0, 0},
                {5, 2, 0, 0, 0, 6, 7, 9, 0},
                {6, 0, 0, 0, 2, 1, 0, 4, 0},
                {0, 0, 0, 5, 3, 0, 9, 0, 0},
                {0, 3, 0, 0, 0, 0, 0, 5, 1}
        };
        int[][] actual = Sudoku.stringsToGrid(
                "3 7 0 0 0 0 0 8 0",
                "0 0 1 0 9 3 0 0 0",
                "0 4 0 7 8 0 0 0 3",
                "0 9 3 8 0 0 0 1 2",
                "0 0 0 0 4 0 0 0 0",
                "5 2 0 0 0 6 7 9 0",
                "6 0 0 0 2 1 0 4 0",
                "0 0 0 5 3 0 9 0 0",
                "0 3 0 0 0 0 0 5 1"
        );
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testSolveValid2() throws Exception {
        int[][] grid = {
                {1, 0, 0, 0, 0, 7, 0, 9, 0},
                {0, 3, 0, 0, 2, 0, 0, 0, 8},
                {0, 0, 9, 6, 0, 0, 5, 0, 0},
                {0, 0, 5, 3, 0, 0, 9, 0, 0},
                {0, 1, 0, 0, 8, 0, 0, 0, 2},
                {6, 0, 0, 0, 0, 4, 0, 0, 0},
                {3, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 4, 0, 0, 0, 0, 0, 0, 7},
                {0, 0, 7, 0, 0, 0, 3, 0, 0}
        };
        Sudoku sudoku = new Sudoku(grid);
        assertArrayEquals(grid, sudoku.getGrid());
    }

}
