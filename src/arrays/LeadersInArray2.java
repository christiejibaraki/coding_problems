package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeadersInArray2 {
	
	public static void main(String[] args){
//		And the rightmost element is always a leader. For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
		
		int[] test = {16,17,4,3,5,2};
		List<Integer> result = new ArrayList<Integer>();
		
		int currentMax = 0;
		for(int i = test.length-1; i>=0; i--){
			int el = test[i];
			if(el > currentMax){
				currentMax = el;
				result.add(el);
			}
		}
		
		for(Integer leader : result){
			System.out.println(leader);
		}
		
	}

}
