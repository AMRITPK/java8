package interfaces;

@FunctionalInterface
interface Multiplier{
	public abstract int mul(int a,int b);
}
public class FnlInterfaces {
	public static void main(String args[]) {
		//int a=10;
		//int b=2;
		
		Multiplier m=(int a,int b)->a*b;
		Multiplier m1=( a, b)->a*b;
		System.out.println(m.mul(1,2));
		System.out.println(m1.mul(1,2));
	}

}
