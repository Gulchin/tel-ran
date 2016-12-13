package tel_ran.texttools.test;

import static org.junit.Assert.*;

import org.junit.Test;
import static tel_ran.texttools.TextAnalyzer.*;

public class TextAnalyzerTest {
	private static final double DELTA = 1e-15;
	
	private TextAnalyzerTest() {
	
	}

	@Test
	public void testFindMaxInt() {
		assertEquals(999, findMaxInt("1dfsf89f;l9   999"));
		assertEquals(1, findMaxInt("1dfsf--89f;l-9   -999"));
		assertEquals(-1, findMaxInt("-1dfsf-89f;l-9   -999"));
		assertEquals(Integer.MIN_VALUE, findMaxInt("dfsff;l"));
	}

	@Test
	public void testFindMaxDouble(){
		assertEquals(999.0d,findMaxDouble("1dfsf89f;l9   999"), DELTA);
		assertEquals(1, findMaxDouble("1dfsf-89f;l-9   -999"), DELTA);
		assertEquals(-1, findMaxDouble("-1dfsf-89f;l-9   -999"), DELTA);
		
		assertEquals(0.999,findMaxDouble("0.1dfsf0.89f;l0.9   0.999"), DELTA);
		assertEquals(1.1,findMaxDouble("1.1dfsf0.89f;l0.9   0.999"), DELTA);
		assertEquals(110.9,findMaxDouble("0.1dfsf0.89f;l110.9   0.999"), DELTA);
		assertEquals(110,findMaxDouble("0.dfsf0.89f;l110.   0.999"), DELTA);
		
		assertEquals(-0.1,findMaxDouble("-0.1dfsf-0.89f;l-1.9   -10.999"), DELTA);
	}
	
	@Test
	public void testFindLongestWord(){
		assertEquals("GHJll", findLongestWord("mdfg56GHJll op"));
		assertEquals("", findLongestWord("Мама мыла раму, кодила программу"));
		assertEquals("longest", findLongestWord("find <-longest-> word"));
	}

	
}
