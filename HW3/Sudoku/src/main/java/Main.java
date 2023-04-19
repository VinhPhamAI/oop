import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        int[][] Grid = Sudoku.stringsToGrid(
                "3 7 0 0 0 0 0 8 0",
                "0 0 1 0 9 3 0 0 0",
                "0 4 0 7 8 0 0 0 3",
                "0 9 3 8 0 0 0 1 2",
                "0 0 0 0 4 0 0 0 0",
                "5 2 0 0 0 6 7 9 0",
                "6 0 0 0 2 1 0 4 0",
                "0 0 0 5 3 0 9 0 0",
                "0 3 0 0 0 0 0 5 1");
        Sudoku sudoku = new Sudoku(Grid);
        if(!sudoku.solve())
        {
            System.out.println("false input");
        }
        else
        {
            sudoku.solve();
            // print every single step in algorithm
            String sudokuString = sudoku.toString();
            System.out.println(sudokuString);
        }
    }
}
