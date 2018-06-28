package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import data.Tuple;

public class SubarayWithGivenSum {
	
	
	public static Tuple<Integer,Integer> getFirstSubarray(Integer[] array, Integer target){
		
		Integer sum = 0;
		Integer start = 0;
		Integer end = null;
		
		for(int i = 0; i < array.length; i++){
			
			sum += array[i];
			end = i;
			
			while(sum > target && start < i){
				sum -= array[start];
				start ++;
			}
			
			if(sum==target){
				return new Tuple<Integer, Integer>(start,end);
			}
			
		}
			
		return new Tuple<Integer, Integer>(-1,-1);
	}
	
	public static void main(String[] args){
		
		Integer[] array = {1,4,3,7,5};
		Tuple<Integer, Integer> result = getFirstSubarray(array, 3);
		System.out.println(result.x);
		System.out.println(result.y);		

	}

}
