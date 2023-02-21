package p2;

import java.util.ArrayList;
import java.util.List;

public class BCD extends ABC{

	public static void main(String[] args) {
		
	List<ABC> firstList=new ArrayList<ABC>();
	
	firstList.add(new ABC());
	firstList.add(new ABC());
	
	List<? super ABC> secondList=firstList;
	
	secondList.add(new ABC());
	
	System.out.println(firstList.size()+secondList.size());
		
		
		
		
		
		
		
		
		
		

	}

}
