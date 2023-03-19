import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

public class AppearancesTest {
	// utility -- converts a string to a list with one
	// elem for each char.
	private List<String> stringToList(String s) {
		List<String> list = new ArrayList<String>();
		for (int i=0; i<s.length(); i++) {
			list.add(String.valueOf(s.charAt(i)));
			// note: String.valueOf() converts lots of things to string form
		}
		return list;
	}

	@Test
	public void testSameCount_Basic_Character() {
		List<String> a = stringToList("abbccc");
		List<String> b = stringToList("cccbba");
		assertEquals(3, Appearances.sameCount(a, b));
	}

	@Test
	public void testSameCount_Basic_Integer() {
		List<Integer> a = Arrays.asList(1, 2, 3, 1, 2, 3, 5);
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 9, 9, 1)));
		assertEquals(2, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1)));
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1, 1)));
	}
	@Test
	public void testCollections() {
		List<Integer> a = Arrays.asList(1,1,2,2,1,6);
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 1, 9, 1)));
		assertEquals(2, Appearances.sameCount(a, Arrays.asList(1, 6, 1, 1)));
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(2, 2, 3, 1, 1)));
	}
	@Test
	public void testCollections_2() {
		List<String> a = stringToList("aaa,2,1,6");
		List<String> b = stringToList("cccbbaaa");
		assertEquals(1, Appearances.sameCount(a, b));
	}
}
