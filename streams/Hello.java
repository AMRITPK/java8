package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hello {
	
	public static List<Integer> oldFilter(List<Integer> alist) {
		List<Integer> retList=new ArrayList();
		for (Integer i :alist) {
			if(i>2) {
				retList.add(i);
			}
		}
		return retList;
	}
	public static void main(String args[]) {
		List<Integer> alist=new ArrayList();
		alist.add(1);
		alist.add(2);
		alist.add(3);
		alist.add(4);
		
		
		System.out.println( Stream.of(alist));
		
		System.out.println( newFilter(alist));
	}
	private static List<Integer>  newFilter(List<Integer> alist) {
		
		return alist.stream().filter(item->item>2).collect(Collectors.toList());
	}
}
