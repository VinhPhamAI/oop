import java.util.HashSet;
import java.util.Set;


// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		int count = 1;
		int longest = 0;
		int length = str.length();
		if(length==0) {return 0;}
		char begin = str.charAt(0);
		for (int i=1;i<length;i++)
		{
			char temp = str.charAt(i);
			if(temp == begin)
			{
				count++;
			}
			else
			{
				if(longest < count) {longest = count;}
				count = 1;
				begin = temp;
			}
		}
		return (longest > count) ? longest : count;
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String expand(int num, char c)
	{
		String s = "";
		for (int i=0;i<num;i++)
		{
			s += c;
		}
		return s;
	}
	public static String blowup(String str) {
		int length = str.length();
		if(length==0) return "";
		for(int i = 0;i<str.length()-1;i++)
		{
			char cur = str.charAt(i);
			if( cur >='0' && cur <= '9' ){
				int num = cur-'0';
				char next = str.charAt(i+1);
				str = str.substring(0,i) + expand(num, next) +str.substring(i+1,str.length()) ;
				i += num-1;
			}
		}
		char end = str.charAt(str.length()-1);
		if(end >='0' && end <='9')
		{
			str = str.substring(0,str.length() - 1);
		}
		return str;
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		if(len <= 0) return true;
		int a_length = a.length();
		int b_length = b.length();
		Set<String> set = new HashSet<String>();
		for (int i=0;i<=a_length-len;i++)
		{
			set.add(a.substring(i,i+len));
		}
		for (int i=0;i<=b_length-len;i++)
		{
			if(set.contains(b.substring(i,i+len))) return true;
		}
		return false;
	}
}
