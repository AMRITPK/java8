package interfaces;


interface vehicle{
	int a=1;
	public default void info() {
		System.out.println("info1");
	}
}


interface engine{
	int a=2;
	public default void info() {
		System.out.println("info engine");
	}
}

class car  implements vehicle,engine{

	@Override
	public void info() {
		// TODO Auto-generated method stub
		
		engine.super.info();
	}
	
}
public class MultipleInheritance {
	public static void main(String args[]) {
		vehicle c=new car();
		c.info();
		
		System.out.println(c.a);
		
	}
}
