package arrays;

import java.util.Arrays;

import data.Tuple;

public class SortZeroOneTwo {
	
	static Tuple<Integer, Integer> swap(int a, int b){
		int temp = a;
		a = b;
		b = temp;
		return new Tuple<Integer, Integer>(a,b);
	}
	
	static void sort012(int a[])
    {
		
		int low = 0;
		int mid = 0;
		int high = a.length -1;
		
		while(mid <= high){
			switch(a[mid]){
			case 0:
				Tuple<Integer, Integer> swapped = swap(a[low], a[mid]);
				a[low] = swapped.x;
				a[mid] = swapped.y;
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				Tuple<Integer, Integer> result = swap(a[high], a[mid]);
				a[high] = result.x;
				a[mid] = result.y;
				high--;
				break;
			}
		}
		

    }
	
	public static void main(String[] args){
		
		int a = 1;
		int b = 2;
		Tuple<Integer, Integer> result = swap(a,b);
		a = result.x;
		b = result.y;
		System.out.println("a: " + a + " ; b: " + b);
		
		
		int[] array = {1,2,1,0,0,2,0};
		sort012(array);
		System.out.println(Arrays.toString(array));
		
	}

}
