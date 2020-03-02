
public class Tester {
public static void main (String args[]) {
	//new Tester().solution(28);
	System.out.println(new Tester().solution(1000));
}

public static int sumDigits(int num) {
	int sum=0;
	while(num>0) {
		sum+=num%10;
		num=num/10;
	}
	return sum;
} 
public int solution(int N) {
	int sumConst=sumDigits(N);
	for(int i=N+1;i<50001;++i) {
		if(sumDigits(i)==sumConst) {
			return i;
		}
	}
	return -1;
    // write your code in Java SE 8
}

}
