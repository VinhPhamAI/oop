import java.util.Arrays;

// Board.java

/**
 * CS108 Tetris Board.
 * Represents a Tetris board -- essentially a 2-d grid
 * of booleans. Supports tetris pieces and row clearing.
 * Has an "undo" feature that allows clients to add and remove pieces efficiently.
 * Does not do any drawing or have any idea of pixels. Instead,
 * just represents the abstract 2-d board.
 */
public class Board	{
    // Some ivars are stubbed out for you:
    private int width;
    private int height;
    private boolean[][] grid;
    private boolean DEBUG = true;
    boolean committed;
    private int maxHeight;
    private int[] widths;
    private int[] heights;

    private int[] widthStore;
    private boolean[][] gridStore;

    private int[] heightStore;


    // Here a few trivial methods are provided:

    /**
     Creates an empty board of the given width and height
     measured in blocks.
     */
    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new boolean[width][height];
        committed = true;

        widths = new int[height];
        heights = new int[width];

        gridStore = new boolean[width][height];
        widthStore = new int[height];
        heightStore = new int[width];

    }


    /**
     Returns the width of the board in blocks.
     */
    public int getWidth() {
        return width;
    }


    /**
     Returns the height of the board in blocks.
     */
    public int getHeight() {
        return height;
    }


    /**
     Returns the max column height present in the board.
     For an empty board this is 0.
     */
    public int getMaxHeight() {
        return maxHeight;
    }

    private void calculateMaxHeight()
    {
        maxHeight = -1;
        for (int i = 0 ; i<heights.length;i++)
        {
            if(maxHeight<heights[i])
                maxHeight = heights[i];
        }
    }

    /**
     Checks the board for internal consistency -- used
     for debugging.
     */
    public void sanityCheck() {

        if (DEBUG) {
            System.out.print(this);
            int[] checkWidths = new int[height];

            int maxHeightCheck =0;

            for(int i = 0; i < width;i++){
                int checkHeight = 0;
                for(int j = 0; j < height;j++){
                    if(grid[i][j])
                    {
                        checkHeight = j+1;
                        checkWidths[j]++;

                        if(maxHeightCheck<j+1)
                            maxHeightCheck = j+1;
                    }
                }
                if(checkHeight!=heights[i])
                    throw new RuntimeException("Height check failed");
            }
            if(!Arrays.equals(checkWidths, widths))
                throw new RuntimeException("Width check failed");

            if(maxHeightCheck != maxHeight)
                throw new RuntimeException("MaxHeight check failed");

        }
    }

    /**
     Given a piece and an x, returns the y
     value where the piece would come to rest
     if it were dropped straight down at that x.
     <p>
     Implementation: use the skirt and the col heights
     to compute this fast -- O(skirt length).
     */
    public int dropHeight(Piece piece, int x) {
        int ans = 0;
        int[] skirt = piece.getSkirt();
        int n = skirt.length;
        for(int i =0 ; i < n ;i++)
        {
            int y = heights[x+i]-skirt[i];
            if(y>ans)
            {
                ans = y;
            }
        }
        return ans;
    }


    /**
     Returns the height of the given column --
     i.e. the y value of the highest block + 1.
     The height is 0 if the column contains no blocks.
     */
    public int getColumnHeight(int x) {
        return heights[x];
    }


    /**
     Returns the number of filled blocks in
     the given row.
     */
    public int getRowWidth(int y) {
        return widths[y];
    }


    /**
     Returns true if the given block is filled in the board.
     Blocks outside of the valid width/height area
     always return true.
     */
    public boolean getGrid(int x, int y) {
        if(x<0 || y< 0 || x>=width || y >=height || grid[x][y]) return true;
        return false;
    }


    public static final int PLACE_OK = 0;
    public static final int PLACE_ROW_FILLED = 1;
    public static final int PLACE_OUT_BOUNDS = 2;
    public static final int PLACE_BAD = 3;

    /**
     Attempts to add the body of a piece to the board.
     Copies the piece blocks into the board grid.
     Returns PLACE_OK for a regular placement, or PLACE_ROW_FILLED
     for a regular placement that causes at least one row to be filled.
     <p>Error cases:
     A placement may fail in two ways. First, if part of the piece may falls out
     of bounds of the board, PLACE_OUT_BOUNDS is returned.
     Or the placement may collide with existing blocks in the grid
     in which case PLACE_BAD is returned.
     In both error cases, the board may be left in an invalid
     state. The client can use undo(), to recover the valid, pre-place state.
     */
    public int place(Piece piece, int x, int y) {
        // flag !committed problem
        if (!committed) throw new RuntimeException("place commit problem");

        int ans = PLACE_OK;
        committed = false;
        reverse();
        int pieceRow,pieceCol;

        TPoint body[] = piece.getBody();
        for(int i =0; i < body.length;i++)
        {
            pieceRow = x+body[i].x;
            pieceCol = y+body[i].y;

            if(pieceRow<0 || pieceRow>=width || pieceCol< 0  || pieceCol >=height )
            {
                ans = PLACE_OUT_BOUNDS;
                break;
            }
            if(grid[pieceRow][pieceCol])
            {
                ans = PLACE_BAD;
                break;
            }

            grid[pieceRow][pieceCol] = true;
            if(heights[pieceRow]<pieceCol+1)
                heights[pieceRow]=pieceCol+1;

            widths[pieceCol]++;

            if(widths[pieceCol] == width)
                ans = PLACE_ROW_FILLED;
        }
        calculateMaxHeight();
        sanityCheck();
        return ans;
    }


    /**
     Deletes rows that are filled all the way across, moving
     things above down. Returns the number of rows cleared.
     */
    public int clearRows() {
        int rowsCleared = 0;
        if(committed)
        {
            committed=false;
            reverse();
        }
        boolean FilledRow = false;
        int rowNext,rowGet;

        for(rowNext=0 , rowGet = 1;rowGet < maxHeight;rowNext++,rowGet++)
        {
            if(!FilledRow && widths[rowNext]==width)
            {
                FilledRow=true;
                rowsCleared++;
            }

            while(FilledRow && rowGet < maxHeight && widths[rowGet]==width)
            {
                rowsCleared++;
                rowGet++;
            }
            if(FilledRow) copySingleRow(rowNext,rowGet);
        }

        if(FilledRow) fillEmptyRows(rowNext,maxHeight);
        for(int i =0;i < heights.length;i++)
        {
            heights[i]-=rowsCleared;
            if(heights[i]>0 && !grid[i][heights[i]-1])
            {
                heights[i]=0;
                for (int j = 0;j<maxHeight;j++ ) {
                    if (grid[i][j]) heights[i] = j + 1;
                }
            }
        }

        calculateMaxHeight();
        sanityCheck();
        return rowsCleared;
    }


    private void fillEmptyRows(int low, int high) {
        for(int i = low;i<high;i++){
            widths[i]=0;
            for(int j = 0;j<width;j++) {
                grid[j][i] = false;
            }
        }
    }
    private void copySingleRow(int rowTo, int rowFrom) {

        if(rowFrom<maxHeight)
        {
            for(int i = 0;i<width;i++)
            {
                grid[i][rowTo] = grid[i][rowFrom];
                widths[rowTo] = widths[rowFrom];
            }
        }
        else
        {
            for(int i = 0;i<width;i++)
            {
                grid[i][rowTo] = false;
                widths[rowTo] = 0;
            }
        }
    }




    /**
     Reverts the board to its state before up to one place
     and one clearRows();
     If the conditions for undo() are not met, such as
     calling undo() twice in a row, then the second undo() does nothing.
     See the overview docs.
     */
    public void undo() {
        if(!committed)
            swap();
        commit();
        sanityCheck();
    }


    /**
     Puts the board in the committed state.
     */
    public void commit() {
        committed = true;
    }
    private void reverse(){

        System.arraycopy(widths, 0, widthStore, 0, widths.length);
        System.arraycopy(heights, 0, heightStore, 0, heights.length);
        for(int i =0;i<grid.length;i++)
            System.arraycopy(grid[i], 0, gridStore[i], 0, grid[i].length);
    }
    private void swap(){
        int[] tmp = widthStore;
        widthStore = widths;
        widths = tmp;


        tmp = heightStore;
        heightStore = heights;
        heights = tmp;

        boolean[][] gridtmp = gridStore;
        gridStore = grid;
        grid = gridtmp;

        calculateMaxHeight();
    }


    /*
     Renders the board state as a big String, suitable for printing.
     This is the sort of print-obj-state utility that can help see complex
     state change over time.
     (provided debugging utility)
     */
    public String toString() {
        StringBuilder buff = new StringBuilder();
        for (int y = height-1; y>=0; y--) {
            buff.append('|');
            for (int x=0; x<width; x++) {
                if (getGrid(x,y)) buff.append('+');
                else buff.append(' ');
            }
            buff.append("|\n");
        }
        for (int x=0; x<width+2; x++) buff.append('-');
        return(buff.toString());
    }
}