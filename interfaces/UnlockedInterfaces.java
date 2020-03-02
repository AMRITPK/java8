package interfaces;


@FunctionalInterface
 interface Person{
	public  abstract void name(String name);
	default boolean isValid() {
		System.out.println("in is valid");
		return true;
	}
}

class Indian implements Person{

	@Override
	public void name(String name) {
		// TODO Auto-generated method stub
		
	}
	
}

public class UnlockedInterfaces {
	public static void main(String args[]) {
		Person i=new Indian();
		i.isValid();
	}
	
	
}
