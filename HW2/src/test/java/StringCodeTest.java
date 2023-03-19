// StringCodeTest
// Some test code is provided for the early HW1 problems,
// and much is left for you to add.

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCodeTest {

	//
	// blowup
	//
	@Test
	public void testBlowup_BasicCases() {
		assertEquals("xxaaaabb", StringCode.blowup("xx3abb"));
		assertEquals("xxxZZZZ", StringCode.blowup("2x3Z"));
	}

	@Test
	public void testBlowup_DigitAtEnd() {
		assertEquals("axxx", StringCode.blowup("a2x3"));
		assertEquals("azzxxx",StringCode.blowup("a1z2x3"));
	}

	@Test
	public void testBlowup_DigitsNextToEachOther() {
		assertEquals("a33111", StringCode.blowup("a231"));
		assertEquals("333333334443333555", StringCode.blowup("2333435"));
	}

	@Test
	public void testBlowup_DigitZero() {
		assertEquals("aabb", StringCode.blowup("aa0bb"));
		assertEquals("aabba",StringCode.blowup("aabba0"));
	}

	@Test
	public void testBlowup_DigitsOnly() {
		assertEquals("", StringCode.blowup("2"));
		assertEquals("33", StringCode.blowup("23"));
	}

	@Test
	public void testBlowup_WeirdChars() {
		assertEquals("AB&&,- ab", StringCode.blowup("AB&&,- ab"));
		assertEquals("  ", StringCode.blowup("  "));
		assertEquals("!@#%%%%",StringCode.blowup("!@#3%1"));
	}
	
	
	//
	// maxRun
	//
	@Test
	public void testMaxRun_BasicCases() {
		assertEquals(2, StringCode.maxRun("hoopla"));
		assertEquals(3, StringCode.maxRun("hoopllla"));
		assertEquals(5, StringCode.maxRun("abscsjjjjjccsw"));
	}

	@Test
	public void testMaxRun_LongestAtEnd() {
		assertEquals(3, StringCode.maxRun("hooplaaa"));
		assertEquals(3, StringCode.maxRun("hooplllaaa"));
		assertEquals(7, StringCode.maxRun("nhuccssssssddddddd"));
	}

	@Test
	public void testMaxRun_LongestAtBeginning() {
		assertEquals(3, StringCode.maxRun("hhhooplaa"));
		assertEquals(4, StringCode.maxRun("hhhhooplllaaa"));
	}

	@Test
	public void testMaxRun_SpecialCases() {
		assertEquals(3, StringCode.maxRun("abbcccddbbbxx"));
		assertEquals("empty string", 0, StringCode.maxRun(""));
		assertEquals(3, StringCode.maxRun("hhhooppoo"));
		assertEquals(10,StringCode.maxRun("bbbbbbbbbb"));
	}

	@Test
	public void testMaxRun_NotSureWhyNeeded() {
		// "evolve" technique -- make a series of test cases
		// where each is change from the one above.
		assertEquals(1, StringCode.maxRun("123"));
		assertEquals(2, StringCode.maxRun("1223"));
		assertEquals(2, StringCode.maxRun("112233"));
		assertEquals(3, StringCode.maxRun("1112233"));
	}

	// Need test cases for stringIntersect
	@Test
	public void StringIntersect_1()
	{
		assertEquals(true,StringCode.stringIntersect("aaashf","bbbaaa",3));
		assertEquals(false,StringCode.stringIntersect("aaaa","zaaab",4));
		assertEquals(true,StringCode.stringIntersect("abc","xyz",0));
		assertEquals(true,StringCode.stringIntersect("abc","xyz",-1));
		assertEquals(false,StringCode.stringIntersect("123a","xyz",1));
		assertEquals(true,StringCode.stringIntersect("xyz","xyz",2));
		assertEquals(false,StringCode.stringIntersect("abc","xyz",4));
		assertEquals(true,StringCode.stringIntersect("12345678","xyz",0));
		assertEquals(true,StringCode.stringIntersect("123","2XY",1));
	}
}
