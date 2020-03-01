
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ConstructorReferences {
	public static void test() {
		System.out.println("in test");
	}
	ConstructorReferences () {
		
	    System.out.println("Hello, this is static method being used as the method passed to callable's functional interface(abstr method)");  
	    //return "ret1";
	}
	public static void main (String args[]) throws InterruptedException, ExecutionException {
		ExecutorService exs= Executors.newFixedThreadPool(3);
		Future<ConstructorReferences> f1 = exs.submit( ConstructorReferences::new);
		//passing constructor as the reference
		
		ConstructorReferences m1= f1.get();
		//constructor returns the new object
		
		m1.test();
		exs.shutdown();
	}
	
	
}


