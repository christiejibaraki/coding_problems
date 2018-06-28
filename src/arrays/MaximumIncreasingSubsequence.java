package arrays;

public class MaximumIncreasingSubsequence {
	
	//Integer[] array = {1, 101, 2, 3};
	// msis = {1, 101, 2, 3};
	
	// i = 1
	// j = 0
	// arr[1] = 101, arr[0] = 1
	// msis[1] = 101, msis[0] + arr[1] = 1+101 = 102
	// msis[1] = 102
	// msis = {1, 102, 2, 3};
	
	// i = 2
	// j = 0
	// arr[2] = 2
	// arr[0] = 1
	// msis[2] = 2; msis[0] + arr[2] = 1 + 2
	// msis[2] = 3
	// msis = {1, 102, 3, 3};
	
	// i = 2
	// j = 1
	// arr[2] = 2
	// arr[1] = 101
	// msis = {1, 102, 3, 3};
	
	static int maxSumIS( Integer arr[], int n )
    {
        int i, j, max = 0;
        int msis[] = new int[n];
 
        /* Initialize msis values for all indexes */
        for ( i = 0; i < n; i++ )
            msis[i] = arr[i];
 
        /* Compute maximum sum values in bottom up manner */
        for ( i = 1; i < n; i++ )
            for ( j = 0; j < i; j++ )
                if ( arr[i] > arr[j] && msis[i] < msis[j] + arr[i])
                    msis[i] = msis[j] + arr[i];
 
        /* Pick maximum of all msis values */
        for ( i = 0; i < n; i++ )
            if ( max < msis[i] )
                max = msis[i];
 
        return max;
    }
	
	public static int findSumOfMaximumIncreasingSubsequence(Integer[] array){
		
		int max = 0;
		
		for(int i = 0; i < array.length; i++){
			
			int end = i;
			int firstNum = array[i];
			int currentNum = 0;
			int currentSum = 0;
			
			while(end < array.length){
				if(array[end] > currentNum){
					currentSum += array[end];
					currentNum = array[end];
				}else if(array[end] > firstNum){
					max = Math.max(max, currentSum);
					currentSum = firstNum + array[end];
					currentNum = array[end];
				}
				end++;
			}			
			max = Math.max(max, currentSum);
		}		
		return max;
	}
	
	public static void main(String[] args){
		Integer[] array = {1, 101, 2, 3, 100, 4, 5};
		System.out.println(findSumOfMaximumIncreasingSubsequence(array));
		
		Integer[] array2 = {10, 5, 4, 3};
		System.out.println(findSumOfMaximumIncreasingSubsequence(array2));
		
		System.out.println(maxSumIS(array, array.length));
		System.out.println(maxSumIS(array2, array2.length));
	}

}
