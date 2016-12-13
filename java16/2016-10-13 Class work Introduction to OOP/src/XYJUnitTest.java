import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class XYJUnitTest {
	private static final int YI = 20;
	private static final String XS = "hello";
	private static final int XI = 10;
	X x;

	@Before
	public void setUp(){
		x=new X(XI, XS, new Y(YI));
	}

	@Test
	public void testGetters() {
		assertEquals(XI,x.getXi());
		assertEquals(XS,x.getXs());
		assertEquals(new Y(YI).getY(),x.getY().getY());
	//	assertEquals(new Y(20),x.getY());
	}
	
	@Test
	public void testToString(){
		System.out.println(x);
	}
	
	@Test
	public void testForEquals(){
		assertEquals(x,new X(XI, XS, new Y(YI)));
	}

}
