import java.io.*;
public class Xappl {

	public static void main(String[] args) throws Exception{
		X x = new X();
		x.a=10;
		x.x=x;
		ObjectOutputStream out=new ObjectOutputStream
				(new FileOutputStream("x.data"));
		out.writeObject(x);
		out.close();

	}

}
