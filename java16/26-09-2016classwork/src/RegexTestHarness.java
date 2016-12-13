import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/* list of regex
 * \ escape symbol
 * 
 * What?
 * .any
 * [] set [abc] [a-c][A-Za-z\-]
 * [^] !set of symbols
 * \d decimal [0-9]
 * \D non digirs
 * \w letters and digits and_
 * \W Non letters and digits and_
 * \s whitespaces space, tab, return etc
 * \S non whitespaces
 * 
 * How many
 * * zero or more
 * + one or more
 * ? zero or one
 * {m} exect number
 * {m,n} from n to m times
 * 
 * ^ begin of the line
 * $ end of the line
 *\
 */
public class RegexTestHarness {

    public static void main(String[] args){
    	Scanner scanner = new Scanner(System.in);        
        while (true) {

        	System.out.print("Enter your regex:              ");
        	String regex = scanner.nextLine();
        	// build mask
            Pattern pattern = Pattern.compile(regex);

        	System.out.print("Enter source string to search: ");
        	String source = scanner.nextLine();
        	// create matcher from mask and string
            Matcher matcher = pattern.matcher(source);

            boolean found = false;
            //finds all matches
            while (matcher.find()) {
            	System.out.printf("I found the text \"%s\" starting at index %d and ending at index %d.%n",
                    matcher.group(),//string finded
                    matcher.start(),//index of find
                    matcher.end()); // index of find +1
                found = true;
            }
            if(!found){
            	System.out.println("No match found.");
            }
            System.out.println();
        }
    }
}
