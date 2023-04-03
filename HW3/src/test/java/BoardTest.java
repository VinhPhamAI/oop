import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


public class BoardTest {
    Board b;
    Piece pyr1, pyr2, pyr3, pyr4, s, sRotated, stick, square;
    Board a;

    // This shows how to build things in setUp() to re-use across tests.

    // In this case, setUp() makes shapes, and also a 3X6 board, with pyr placed at the bottom,
    // ready to be used by tests.

    @Before
    public void setUp() {
        b = new Board(3, 6);
        a = new Board(3,6);
        pyr1 = new Piece(Piece.PYRAMID_STR);
        pyr2 = pyr1.computeNextRotation();
        pyr3 = pyr2.computeNextRotation();
        pyr4 = pyr3.computeNextRotation();

        s = new Piece(Piece.S1_STR);
        sRotated = s.computeNextRotation();
        stick = new Piece(Piece.STICK_STR);
        square = new Piece(Piece.SQUARE_STR);

        b.place(pyr1, 0, 0);
        a.place(stick, 0 , 0);
    }

    @Test
    public void testSample1() {
        assertEquals(1, b.getColumnHeight(0));
        assertEquals(2, b.getColumnHeight(1));
        assertEquals(2, b.getMaxHeight());
        assertEquals(3, b.getRowWidth(0));
        assertEquals(1, b.getRowWidth(1));
        assertEquals(0, b.getRowWidth(2));
    }

    // Place sRotated into the board, then check some measures
    @Test
    public void testSample2() {
        b.commit();
        int result = b.place(sRotated, 1, 1);
        assertEquals(Board.PLACE_OK, result);
        assertEquals(1, b.getColumnHeight(0));
        assertEquals(4, b.getColumnHeight(1));
        assertEquals(3, b.getColumnHeight(2));
        assertEquals(4, b.getMaxHeight());
    }

    @Test
    public void test1(){
        b.commit();
        int result = b.place(stick, 0, 1);
        assertEquals(Board.PLACE_OK, result);

        b.commit();
        result = b.place(sRotated, 1, 1);

        assertEquals(Board.PLACE_ROW_FILLED, result);
        assertEquals(5, b.getMaxHeight());
        assertEquals(4, b.getColumnHeight(1));
        assertEquals(3, b.getColumnHeight(2));
        assertEquals(2, b.getRowWidth(3));

        int numRowsCleared = b.clearRows();
        assertEquals(3,numRowsCleared);
        assertEquals(1,b.getRowWidth(1));

        b.undo();
        assertEquals(5, b.getMaxHeight());
        assertEquals(2,b.getColumnHeight(1));
        assertEquals(1,b.getColumnHeight(2));
        assertEquals(3, a.getWidth());
        assertEquals(0, a.getRowWidth(4));
        assertEquals(3, b.getWidth());
        assertEquals(6, b.getHeight());

    }

    @Test
    public void test2(){
        assertTrue(b.getGrid(1, 1));

        b.undo();

        int result = b.place(square, 0, 0);
        b.commit();

        assertEquals(Board.PLACE_OK, result);

        result = b.place(square, 0, 2);
        b.commit();

        assertEquals(Board.PLACE_OK, result);

        result = b.place(square, 0, 4);
        b.commit();

        assertEquals(Board.PLACE_OK, result);

        result = b.place(stick, 2, 0);
        b.commit();

        assertEquals(Board.PLACE_ROW_FILLED, result);
        assertEquals(6, b.getMaxHeight());

        int numRowsCleared = b.clearRows();

        assertEquals(4,numRowsCleared);
        assertEquals(2, b.getMaxHeight());
        assertEquals(2,b.getColumnHeight(1));
        assertEquals(0,b.getColumnHeight(2));
        assertEquals(2,b.getRowWidth(1));

        assertTrue(b.getGrid(78, 56));
    }

    @Test
    public void test3(){
        //checking board width and height
        assertEquals(3, b.getWidth());
        assertEquals(6, b.getHeight());
        assertEquals(3, a.getWidth());
        assertEquals(6, a.getHeight());
        b.commit();
        a.commit();
        assertEquals(2,b.dropHeight(sRotated, 0));
        assertEquals(1,b.dropHeight(stick, 2));
        assertEquals(1,b.dropHeight(pyr2, 1));

        int result = b.place(pyr4, 0, 1);

        assertEquals(Board.PLACE_OK, result);
        assertEquals(2,b.dropHeight(sRotated, 1));
        assertEquals(1,b.dropHeight(stick, 2));
        assertEquals(2,b.getRowWidth(2));

        b.undo();

        assertEquals(2,b.getMaxHeight());
        assertTrue(a.getMaxHeight() != 2);

        result = b.place(pyr3, 0, 2);

        assertEquals(Board.PLACE_ROW_FILLED, result);

        b.commit();
        result = b.place(pyr3, 0, 4);

        assertEquals(Board.PLACE_ROW_FILLED, result);
        assertEquals(3,b.clearRows());
    }

    @Test
    public void test4(){
        assertEquals(3,b.getRowWidth(0));
        assertEquals(1,b.clearRows());
        b.commit();
        assertEquals(1,b.getRowWidth(0));
        int result = b.place(pyr4, 0, 0);
        int rowsCleared = b.clearRows();
        b.commit();
        assertEquals(Board.PLACE_OK, result);
        assertEquals(0,rowsCleared);
        assertEquals(3,b.getMaxHeight());
        result = b.place(sRotated, 1, 1);
        assertEquals(4,b.getMaxHeight());
        rowsCleared = b.clearRows();
        b.commit();
        assertEquals(Board.PLACE_ROW_FILLED, result);
        assertEquals(2,rowsCleared);
        assertEquals(2,b.getMaxHeight());
        result = b.place(sRotated, 1, 1);
        rowsCleared = b.clearRows();
        a.commit();
        assertEquals(Board.PLACE_OK, result);
        assertEquals(0,rowsCleared);
        assertEquals(4,b.dropHeight(square, 1));
        assertEquals(3,b.dropHeight(sRotated, 1));
        assertEquals(2,b.getRowWidth(0));
        assertEquals(1,b.getRowWidth(3));
        assertEquals(4,b.getColumnHeight(1));
        assertTrue(!b.getGrid(1, 4));
        assertTrue(b.getGrid(1, 3));
        assertTrue(!a.getGrid(1,3));

    }

}
