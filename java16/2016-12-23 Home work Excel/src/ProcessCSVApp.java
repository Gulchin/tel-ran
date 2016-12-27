import java.io.*;

public class ProcessCSVApp {
	public static final String inputFile="input.csv";
	public static final String outputFile="output.csv";
	public static final String RESULT="result";
	public static final String DELIMITER=";";

	public static void main  (String[] args) {
		try(
		BufferedReader reader=new BufferedReader (new FileReader(inputFile));
		PrintWriter writer=new PrintWriter(outputFile);
		){
			StringBuilder input=new StringBuilder(reader.readLine());
			input.append(DELIMITER).append(RESULT);
			writer.println(input);
			while(reader.ready()){
				 input=new StringBuilder(reader.readLine());
				writer.println(processLine(input));
			}
			writer.flush();
		} catch (IOException e){
			System.out.println("IO error");
		}
	}
	
	
	private static String  processLine(StringBuilder line){
		String [] ops=line.toString().split(DELIMITER);
		String res="*";
		try{
			int op1=Integer.parseInt(ops[0]);
			int op2=Integer.parseInt(ops[1]);
			
			switch(ops[2].toLowerCase()){
			case "+": case "add": res=String.valueOf(op1+op2);
				break;
			case "-": case "substruct": res=String.valueOf( op1-op2);
				break;
			case "*": case "multiply": res=String.valueOf(op1*op2);
				break;
			case "/": case "divide": res=String.valueOf(op1/op2);
				break;
			default: throw new IllegalArgumentException();
			}
			
		}catch(Exception e){
			
		}
		
		return line.append(DELIMITER).append(res).toString();
	}
	
}
