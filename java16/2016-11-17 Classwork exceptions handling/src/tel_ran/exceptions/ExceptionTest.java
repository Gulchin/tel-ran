package tel_ran.exceptions;
//Дз написать класс Cheknumbers  с двумя статическими методами isNumber(String number) должна вернуть истину елси в строке
// любое число isInteger - определяет, что именно целое число.
// Дополнительное задание - Найти максимально возможную память, которую можно выполнить на вашей системе
// бинарный поиск?
public class ExceptionTest {

	public static void main(String args[]){
//		int[] array={1,2,3};
//		int index=5;
//		int number=0;
//		try{
//			int n=getNumber(null,index);
//			System.out.println(n);
//			number+=3;
//			return;// Все равно выполняется finally!!!
//		} 
//		catch(ArrayIndexOutOfBoundsException e){
//			number=5;
//			return;
//		}
//		catch(Throwable e){
//			number=10;
//			System.out.println("error: "+e.getMessage());
//			return;
//		}
//		finally{
//			//number=100;
//			System.out.println(number);
//		}
//	int size=2147483646;
//	boolean flag=true;
//	while(flag){
////		try{
//		 byte []array=new byte[size];
//		 flag=false;
//		 System.out.println(size);
////		}catch (Throwable e){
////			size/=2;
////		}
//	}
		System.out.println(getX());
	
	}
	
	private static StringBuilder getX() {
		StringBuilder x=new StringBuilder();
		try{
			x.append("1");
			return x;
		}catch(Exception e){
			return x;
		} finally{
			x.append("5");
		}	 
	}

	public static int getNumber(int [] array,int index){
		return array[index];
	}
	
}
