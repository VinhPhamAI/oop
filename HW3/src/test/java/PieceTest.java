import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/*
  Unit test for Piece class -- starter shell.
 */
public class PieceTest {
    // You can create data to be used in the your test cases like this.
    // For each run of a test method, a new PieceTest object is created
    // and setUp() is called automatically by JUnit.
    // For example, the code below sets up some pyramid and s pieces
    // in instance variables that can be used in tests.
    private Piece pyr1, pyr2, pyr3, pyr4;
    private Piece s, sRotated;
    private Piece sqr1, sqr2, sqr3;
    private Piece[] pieces;
    private Piece stick1, stick2, stick3;
    private Piece l21, l22, l24;
    private Piece l11, l12, l13;
    @Before
    public void setUp() throws Exception{
        pyr1 = new Piece(Piece.PYRAMID_STR);
        pyr2 = pyr1.computeNextRotation();
        pyr3 = pyr2.computeNextRotation();
        pyr4 = pyr3.computeNextRotation();
        sqr1 = new Piece(Piece.SQUARE_STR);
        sqr2 = sqr1.computeNextRotation();
        sqr3 = sqr2.computeNextRotation();
        s = new Piece(Piece.S1_STR);
        sRotated = s.computeNextRotation();
        stick1 = new Piece(Piece.STICK_STR);
        stick2 = stick1.computeNextRotation();
        stick3 = stick2.computeNextRotation();
        l21 = new Piece(Piece.L2_STR);
        l22 = l21.computeNextRotation();
        l24 = l22.computeNextRotation();
        l11 = new Piece(Piece.L1_STR);
        l12 = l11.computeNextRotation();
        l13 = l12.computeNextRotation();
        pieces = Piece.getPieces();
    }

    // Here are some sample tests to get you started
    @Test
    public void testSampleSize() {
        // Check size of pyr piece
        assertEquals(3, pyr1.getWidth());
        assertEquals(2, pyr1.getHeight());

        // Now try after rotation
        // Effectively we're testing size and rotation code here
        assertEquals(2, pyr2.getWidth());
        assertEquals(3, pyr2.getHeight());

        // Now try with some other piece, made a different way
        Piece l = new Piece(Piece.STICK_STR);
        assertEquals(1, l.getWidth());
        assertEquals(4, l.getHeight());

    }


    // Test the skirt returned by a few pieces
    @Test
    public void testSampleSkirt() {
        // Note must use assertTrue(Arrays.equals(... as plain .equals does not work
        // right for arrays.
        assertTrue(Arrays.equals(new int[]{0, 0, 0}, pyr1.getSkirt()));
        assertTrue(Arrays.equals(new int[]{1, 0, 1}, pyr3.getSkirt()));
        assertTrue(Arrays.equals(new int[]{0, 0, 1}, s.getSkirt()));
        assertTrue(Arrays.equals(new int[]{1, 0}, sRotated.getSkirt()));
    }
    @Test
    public void test_Equal ()
    {
        assertTrue(sqr1.equals(sqr2));
        assertTrue(sqr1.equals(sqr3));
        assertTrue(sqr2.equals(new Piece("1 0 0 0 1 1 0 1")));
        assertTrue(!stick1.equals(stick2));
        assertTrue(stick1.equals(stick3));
        assertTrue(!l21.equals(l24));
        assertTrue(!l21.equals(new Piece("0 0 1 0 0 1 0 2")));
        assertTrue(l21.equals(l21.computeNextRotation().computeNextRotation().computeNextRotation().computeNextRotation()));
        assertTrue(!pyr1.equals(pyr3));
        assertTrue(!l22.equals(stick3));
    }

    @Test
    public void test_getWidth()
    {
        assertEquals(1, stick1.getWidth());
        assertEquals(3,l22.getWidth());
        assertEquals(4, stick2.getWidth());
        assertEquals(2, pyr2.getWidth());
        assertEquals(2, pyr1.getHeight());
    }
    @Test
    public void test_getHeight()
    {
        assertEquals(2,sqr1.getHeight());
        assertEquals(2,sqr3.getHeight());
        assertEquals(1, stick2.getHeight());
        assertEquals(4, stick1.getHeight());
        assertEquals(3,sRotated.getHeight());
    }
    @Test
    public void test_getSkirt()
    {
        assertTrue(Arrays.equals(new int[] {1, 0, 1}, pyr3.getSkirt()));
        assertTrue(Arrays.equals(new int[] {1, 0}, pyr2.getSkirt()));
        assertTrue(Arrays.equals(new int[] {0, 0, 0}, pyr1.getSkirt()));
        assertTrue(Arrays.equals(new int[] {0, 0, 0}, pyr3.computeNextRotation().computeNextRotation().getSkirt()));
        assertTrue(Arrays.equals(new int[] {0, 0, 1}, s.getSkirt()));
        assertTrue(Arrays.equals(new int[] {0}, stick3.getSkirt()));
        assertTrue(Arrays.equals(new int[] {1, 1, 0}, l22.getSkirt()));
        assertTrue(!Arrays.equals(new int[] {0, 0, 0, 1}, l11.getSkirt()));
        assertTrue(Arrays.equals(new int[] {1, 0}, sRotated.getSkirt()));

    }
    @Test
    public void test_fastRotation ()
    {
        assertTrue(sqr2.equals(pieces[Piece.SQUARE].fastRotation().fastRotation().fastRotation().fastRotation().fastRotation().fastRotation().fastRotation()));
        assertTrue(stick1.equals(pieces[Piece.STICK].fastRotation().fastRotation()));
        assertTrue(l24.equals(pieces[Piece.L2].fastRotation().fastRotation()));
        assertTrue(pyr3.equals(pieces[Piece.PYRAMID].fastRotation().fastRotation().fastRotation().fastRotation().fastRotation().fastRotation()));
        assertTrue(!s.equals(pieces[Piece.L1].fastRotation()));
        assertTrue(sRotated.equals(pieces[Piece.S1].fastRotation().fastRotation().fastRotation().fastRotation().fastRotation()));
    }
}
