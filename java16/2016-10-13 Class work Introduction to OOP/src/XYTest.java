
/*
 * Дз написать класс Employee{int id, String name, int sallary, Company company}
 * Cjmpany {String name, String country}
 * + тесты
 */

public class XYTest {
 public static void main(String [] args){
	 String s="hello";
	 X x=new X(5,s, new Y(10));
	 System.out.println(x.toString());
//	 x.getY().setY(11);
	 s=s+"!";
	 System.out.println(x.toString());
 }
}
