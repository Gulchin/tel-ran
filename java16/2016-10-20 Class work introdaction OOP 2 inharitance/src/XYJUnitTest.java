import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class XYJUnitTest {
	private static final int YI = 20;
	private static final String XS = "hello";
	private static final int XI = 10;
	private static final int XI1 = 2;
	private static final int XI2 = 3;
	private static final int XI11 = 200;
	private static final int XI12 = 1;
	private static final int X2I = 2;
	X x;
	X[] arrayX;

	@Before
	public void setUp(){
		x=new X(XI, XS, new Y(YI));
		arrayX=new X[]{new X(XI,XS,new Y(YI)),
				new X1(XI,XS,new Y(YI),XI1,XI2),
				new X11(XI,XS,new Y(YI),XI1,XI2, XI11, XI12),
				new X2(XI,XS,new Y(YI), X2I)};
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
	
	@Test
	public void testComputeX(){
		int sumX=0;
		for (int i=0;i<arrayX.length;i++){
			sumX+=arrayX[i].computeX();
		}
		
		int expected =XI+XI+XI1*XI2+XI+XI1*XI2+XI11*XI12/100+XI*X2I;
		assertEquals(expected, sumX);
	}

}
