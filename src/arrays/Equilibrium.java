package arrays;

import java.util.Arrays;

public class Equilibrium {
	
	public static int correctSolution(Integer[] array){
		
		int sum = findSum(array);
		int leftSum = 0;
		
		for(int i = 0; i < array.length; i++){
			
			sum -= array[i];
			if(sum==leftSum){
				return array[i];
			}
			
			leftSum += array[i];
			
		}
		
		return -1;
	}
	
	public static int findEquilibrium(Integer[] array){
		
		int firstSum = 0;
		for(int i = 0; i < array.length; i++){
			Integer[] subset = Arrays.copyOfRange(array, i+1, array.length);
			if(findSum(subset)==firstSum){
				return array[i];
			}	
			firstSum += array[i];
		}
		return -1;
	}
	
	private static int findSum(Integer[] array){
		int sum = 0;
		for(Integer element : array){
			sum += element;
		}
		return sum;
	}
	
	public static void main(String[] args){
		Integer[] array = {1,3,5,2,2};
		System.out.println(findEquilibrium(array));
		System.out.println(correctSolution(array));
		
		Integer[] array2 = {1};
		System.out.println(findEquilibrium(array2));
		System.out.println(correctSolution(array2));
		
	}

}
