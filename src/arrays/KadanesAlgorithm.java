package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KadanesAlgorithm {
	
	public static int correctAnswer(Integer[] array){
		int currentMax = array[0];
		int globalMax = currentMax;
		for(int i = 1; i < array.length; i++){
			currentMax = Math.max(currentMax + array[i],  array[i]);
			if(currentMax > globalMax){
				globalMax = currentMax;
			}
		}
		
		return globalMax;
	}
	
	public static void main(String[] args){
		
		Integer[] array = {-1,2,3,4,-5};
		
		Set<Integer> sums = new HashSet<>(Arrays.asList(array));	

		for(int rowIndex = (array.length-1); rowIndex>=0; rowIndex--){			
			int currentSum = array[rowIndex];
			for(int diff = 1; diff < (rowIndex+1); diff++){
				currentSum += array[rowIndex-diff];
				sums.add(currentSum);				
			}
		}
		
		System.out.println(Collections.max(sums));
		
		System.out.println(correctAnswer(array));
		
		
	}

}
