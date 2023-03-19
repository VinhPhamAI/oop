import java.util.*;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		Map<T,Integer> map1 = Counts(a);
		Map<T,Integer> map2 = Counts(b);
		int count = 0;
		for (T i : map1.keySet())
		{
			if(map1.get(i) == map2.get(i) ) count++;
		}
		return count;
	}
	private static <T> Map<T, Integer> Counts(Collection<T> ch) {
		Map<T, Integer> Mp = new HashMap<T, Integer>();
		for(T i : ch)
		{
			Integer count = Mp.get(i);
			if(count == null) count = 0;
			Mp.put(i, count + 1);
		}
		return Mp;
	}
}
