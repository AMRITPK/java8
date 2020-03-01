import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CApturingLambda_final_local_classvariable {
	String calssvar="asdf";
public  void tester() throws InterruptedException, ExecutionException {
	String a="hello";
	
	a="asdf";
	//Local variable a defined in an enclosing scope must be final or effectively final
	//why -. because threads shoudld not change the variable in the stack- local var
	
	ExecutorService exserv = Executors.newFixedThreadPool(10);
	Future<String> f1 = exserv.submit(()->{
		calssvar="sdfgsdfg";
		//class variables can be changed -BUT MUTATING CLASS OR INSTANCE VARIABLE CAN CREATE CINCURRENCY ISSUES
		return calssvar+"done";
	});
	
	System.out.println(f1.get());
	exserv.shutdown();
}
	
public static void main(String args[]) throws InterruptedException, ExecutionException {
	new CApturingLambda_final_local_classvariable().tester();

	
}

}
