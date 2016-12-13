
public class RegexTestClass {
//Дз checkPassword построить тест, проверяющий функциональность чек пассворд. И написать функциональность
	//которая вернет максимальное число и найти слово максимальной длины и вернуть
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="abcd,,,,,lmn    1234";
		String [] res=str.split("[^a-zA-Z]+");
		System.out.println(str.matches("[A-Za-z]*"));
		System.out.println(res.length);
		for(String s: res){
			if (!s.equals(""))
			System.out.println(s);
		}
		
		String s1="Hello";
		String s2="He"+"llo";
		System.out.println(s1==s2);
	}

}
