
import java.util.concurrent.*;
public class Lambda {
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		
		 ExecutorService exServ = Executors.newFixedThreadPool(10);
		 
		 Future<String> fut1 = exServ.submit(()->"done callable");
		 Future fut2 = exServ.submit(()->System.out.println("in runable"));
		 
		 //note lambda can be callable or runnable..
		 //compiler checks if its matching either one based on the method signature
		 
		 
		 System.out.println(	 fut1.get());
		 System.out.println(	 fut2.get());
		 exServ.shutdown();
		
		 
		
	}
}
