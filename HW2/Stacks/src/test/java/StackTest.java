import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    @Test
    public void testPushAndPop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, (int) stack.pop());
        assertEquals(2, (int) stack.pop());
        assertEquals(1, (int) stack.pop());
    }
    @Test
    public void testIsEmpty() {
        Stack<Double> stack = new Stack<>();
        assertTrue(stack.isEmpty());
        stack.push(0.5);
        assertFalse(stack.isEmpty());
    }

    private static Stack<String> stack;
    @BeforeAll
    public static void setUp() {
        stack = new Stack<>();
    }
    @Test
    public void testPush() {
        stack.push("Hello");
        stack.push("world");
    }

    @Test
    public void testPop() {
        stack.push("Hello");
        stack.push("world");
        String s = stack.pop();
        assertEquals("world", s);

    }
    @Test
    public void testIsEmpty2() {
        assertTrue(stack.isEmpty());
        stack.push("Hello");
        assertFalse(stack.isEmpty());
    }
}
