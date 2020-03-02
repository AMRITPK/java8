package functions;
import java.util.function.*;

public class Predicate_usages {
	
	
public static void main(String args[]) {
	Predicate<String> p=(String s)-> s.isEmpty();
	
	System.out.println(p.test("amrit"));
}


}
