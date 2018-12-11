package arrays;

import java.util.ArrayList;
import java.util.List;

public class LeadersInAnArray {
	
	public static List<Integer> findLeaders(Integer[] array){
		
		List<Integer> result = new ArrayList<Integer>();
		int currentMax = -1;
		for(int i = array.length-1; i >= 0; i--){
			if(array[i] > currentMax){
				result.add(array[i]);
				currentMax = array[i];
			}
			
		}
		
		return result;
		
	}
	
	public static void main(String[] args){
		Integer[] array = {16, 17, 4, 3, 5, 2};
		List<Integer> result = findLeaders(array);
		for(Integer el : result){
			System.out.println(el);
		}
		
		Integer[] array2 = {1, 2, 3, 4, 0};
		result = findLeaders(array2);
		for(Integer el : result){
			System.out.println(el);
		}
	}

}
