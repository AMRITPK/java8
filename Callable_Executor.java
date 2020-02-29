import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class C2 implements Callable{
	private int number;
	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		TimeUnit.SECONDS.sleep(10);
		System.out.println(number+"=number");
		return 2*number;
	}
	C2(int number){
		this.number=number;
	}
	
}
public class Callable_Executor {
	

	
	public static void main (String args[]) {
	
		
		Callable c2=new C2(2);
		
		try {
			
			Callable c1= (()-> {System.out.println("asdff"); return "str to ret";});
			
			
			
			ExecutorService service = Executors.newFixedThreadPool(10);
			 Collection<Callable<String>> tasks = new ArrayList<>();
			
		
			 
			
			tasks.add(c2);
			tasks.add(c1);
			
			
			java.util.List<Future<String>> alist = service.invokeAll(tasks);
			
			
			alist.forEach((item)->{
				try {
					Future f=item;
					System.out.println(f.isDone()+"-"+f.get());
					
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
			
		
			//Future b = service.submit(c1);
			//Future a = service.submit(c2);
			//boolean retval = service.awaitTermination(2, TimeUnit.SECONDS);
			//System.out.println(retval);
			//System.out.println(a.get().toString());
			//service.shutdown();
			
		
			//System.out.println(b.get().toString());
			service.shutdown();
			
			 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
