import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class N_Task_Parallel {
	public static void log(String s) {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		System.out.println(formatter.format(date));
		System.out.println(s);
	}
	
	public static void pingAndReportEachWhenKnown() throws InterruptedException{
		Callable c1=(()-> {
		
			log("c1 started");
			TimeUnit.SECONDS.sleep(10);
			return "returning from c1";
		});
		Callable c2=(()-> {
	
			log("c2 started");
			TimeUnit.SECONDS.sleep(5);
			return "returning from c2";
		});
		
		ExecutorService exService=  Executors.newFixedThreadPool(10);
		ExecutorCompletionService comService=new ExecutorCompletionService(exService);
		comService.submit(c1);
		comService.submit(c2);
		
		Future f1=comService.take();
		try {
			log("f1.get()");
			log(f1.get().toString());
			Future f2=comService.take();
			log("f2.get()");
			log(f2.get().toString());
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		exService.shutdown();
	}
	
	
	public static void main(String args[]) {
		try {
			//pingAndReportEachWhenKnown();
		
				pingAndReportAllAtEnd ();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void pingAndReportAllAtEnd () throws Exception {
		// TODO Auto-generated method stub
		Callable c1= ()->{
			log("inside c 1");
			TimeUnit.SECONDS.sleep(10);
			log("done c 1");
			return "from c1";
		};
		Callable c2= ()->{
			log("inside c 2");
			TimeUnit.SECONDS.sleep(5);
			log("done c 2");
			return "from c2";
		};
		
		 ExecutorService exs= Executors.newFixedThreadPool(10);
		 Future r1 = exs.submit(c1);
		 Future r2 = exs.submit(c2);
		 
		log( r1.get().toString());
		log( r2.get().toString());
		exs.shutdown();
	}
}
