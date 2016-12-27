import java.io.*;

//Дз (csv - кома сепаратенд файл) Входной файл в этом формате - содержит:
// заголовок: операнд1, операнд2, оперейшен
//				2 			2 		multiply
//				3			5		Add
//				7 			8		substruct
//				10			2		devide
//
//выходной файл
//заголовок: операнд1, операнд2, оперейшен, резалтат
//				2			2      multiply   4
public class BufferedReaderTestUp {
	public static final String PROPMT="Please enter operation line in format <op1> <op2> <operation> or exit";
	public static final String ERROR="Wrong input line. Please enter operation line in format <op1> <op2> <operation> or exit";

	public static void main(String[] args) throws IOException {
		//BufferedReader reader=new BufferedReader(new FileReader("src/BufferedReaderTestUp.java"));
//		while(reader.ready()) System.out.println(reader.readLine());
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		String input="";
		String prompt=PROPMT;
		do{
			System.out.println(prompt);

			try{
				input=reader.readLine();
				if("exit".equalsIgnoreCase(input) )break;
				System.out.println(processOpeation(input));
				prompt=PROPMT;
			}catch(Exception e){
				prompt=ERROR;
			}
			
		}while(true);

	}

	private static int processOpeation(String input) {
		String [] words=input.split(" ");
		int op1=Integer.parseInt(words[0]);
		int op2=Integer.parseInt(words[1]);
		
		switch(words[2]){
		case "+": return op1+op2;
		case "-": return op1-op2;
		case "*": return op1*op2;
		case "/": return op2!=0 ? op1/op2 : Integer.MAX_VALUE;
		default: throw new IllegalArgumentException();
		}
		
	}

}
