import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class MethodReferences {
	
	public static  String testStatic () {
		
	    System.out.println("Hello, this is static method being used as the method passed to callable's functional interface(abstr method)");  
	    return "ret1";
	}
	public static void main (String args[]) throws InterruptedException, ExecutionException {
		ExecutorService exs= Executors.newFixedThreadPool(3);
		//Future f1 = exs.submit(new MethodReferences()::testStatic);
		Future f1 = exs.submit(()->{testStatic();});
		
		System.out.println(f1.get());
		exs.shutdown();
	}
	
	
}


