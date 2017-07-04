package productofothernumbers;

public class ProductOfOtherNumbers {

	public int[] getProduct(int[] numbers){
		if(numbers == null) return null;
		
		int[] result = new int[numbers.length];
		
		int[] arrBefore = new int[numbers.length];
		int[] arrAfter = new int[numbers.length];
		int productBefore = 1;
		int productAfter = 1;
		int b = numbers.length - 1;
		
		//Organize the data
		for(int a = 0; a < numbers.length; a++){
			arrBefore[a] = productBefore;
			arrAfter[b] = productAfter;
			productBefore *= numbers[a];
			productAfter *= numbers[b];
			b--;
		}
		
		//Calculate the result
		for(int a = 0; a < numbers.length; a++){
			result[a] = arrBefore[a] * arrAfter[a];
		}
		
		return result;
	}
}
