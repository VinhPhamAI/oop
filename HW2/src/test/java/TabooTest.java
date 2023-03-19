// TabooTest.java
// Taboo class tests -- nothing provided.
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
public class TabooTest {
    @Test
    public void tabooTest1() {
        Taboo<Integer> taboo = new Taboo<Integer>(new ArrayList<Integer>(Arrays.asList(0,2,3,0,3,null,4,2,5,6,null)));
        assertSetsEqual(taboo.noFollow(0), createSet(2,3));
        assertSetsEqual(taboo.noFollow(2), createSet(3,5));
        assertSetsEqual(taboo.noFollow(5), createSet(6));

        ArrayList<Integer> list = new ArrayList<Integer>();
        taboo.reduce(list);
        assertListsEqual(list, new ArrayList<Integer>());

        assertListsEqual(reduced_List(taboo, 0, 2),
                new ArrayList<Integer>(Arrays.asList(0)));
        assertListsEqual(reduced_List(taboo, 0,2,3,4,2,5,0,3,4,2),
                new ArrayList<Integer>(Arrays.asList(0,4,5,0,4)));
    }

    @Test
    public void tabooNullTest() {
        Taboo<Character> taboo = new Taboo<Character>(new ArrayList<Character>(Arrays.asList('a', null, 'b', 'c', null, null, 'c', 'b', 'a', null)));

        assertSetsEqual(taboo.noFollow('a'), new HashSet<Character>());
        assertSetsEqual(taboo.noFollow('b'), createSet('a', 'c'));
        assertSetsEqual(taboo.noFollow(null), new HashSet<Character>());

        assertListsEqual(reduced_List(taboo, 'a', 'c', 'b', 'd'),
                new ArrayList<Character>(Arrays.asList('a', 'c', 'd')));
    }
    @Test
    public void taboo_Test_Hard() {
        Taboo<Character> taboo = new Taboo<Character>(new ArrayList<Character>(Arrays.asList('a', null , 'b', 'e' , 'c','f', null, null, 'c', 'b', 'a', null,'d')));

        assertSetsEqual(taboo.noFollow('a'), new HashSet<Character>());
        assertSetsEqual(taboo.noFollow('b'), createSet('a', 'e'));
        assertSetsEqual(taboo.noFollow(null), new HashSet<Character>());
        assertSetsEqual(taboo.noFollow(null),new HashSet<Character>());
        assertSetsEqual(taboo.noFollow('c'),createSet('b', 'f'));

        assertListsEqual(reduced_List(taboo, 'a', 'c', 'b', 'd'),
                new ArrayList<Character>(Arrays.asList('a', 'c', 'd')));
    }
    private <T> ArrayList<T> reduced_List(Taboo<T> taboo, T... objs) {
        ArrayList<T> list = new ArrayList<T>(Arrays.asList(objs));
        taboo.reduce(list);
        return list;
    }

    private <T> void assertSetsEqual(Set<T> s1, Set<T> s2) {
        assertEquals(s1.size(), s2.size());
        for(T t : s1) {
            assert(s2.contains(t));
        }
    }

    private <T> void assertListsEqual(List<T> l1, List<T> l2) {
        assertEquals(l1.size(), l2.size());
        for(int i = 0; i < l1.size(); i++) {
            assertEquals("Index " + i, l1.get(i), l2.get(i));
        }
    }

    private <T> Set<T> createSet(T... objs) {
        Set<T> set = new HashSet<T>();
        set.addAll(Arrays.asList(objs));
        return set;
    }

}
