package tel_ran.sapes;

import org.junit.Before;
import org.junit.Test;

public class ShapeTest {
	Shape [] shapes;
	
	@Before
	public void setUp(){
		shapes=new Shape[]{new Shape('*'),new LineHorizontally('*', 3),
				new LineVertically('*', 3), new SquareEmty('*', 3),
				new RectangleEmpty('*', 3, 5), new Square('*', 3),
				new Rectangle('*', 3, 5)
		};
		
	}

	@Test
	public void testDraw() {
		for (Shape shape: shapes){
			System.out.printf("This is a %s: \n",shape.getClass().getSimpleName());
			shape.draw();
			Shape.nextLine();
		}
	}

}
