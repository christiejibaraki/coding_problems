package arrays;

public class MissingNumber {
	
	public static int correctAnswer(Integer[] array){
		int total = (array.length+1)*(array[0] + array[array.length-1])/2;
		for(int i = 0 ; i < array.length; i++){
			total -= array[i];
		}
		return total;
	}
	
	public static void main(String[] args){
		Integer[] array = {3,4,5,6,8};
		
		for(int i = 0 ; i < (array.length-1); i++){
			if(array[i+1]!=array[i]+1){
				System.out.println("answer: " + (array[i]+1));
				break;
			}
		}
		
		System.out.println(correctAnswer(array));

	}

}
