import java.util.HashSet;
import java.util.Set;

public class TwoSum {
	
	/*
	 Given an array of integers and an integer target, find any 2 numbers in the list that add up to the target.
	 */
	public int[] calculate(int[] arrData, int target){
		int[] twoSum = new int[2];
		if(target > Integer.MIN_VALUE && target < Integer.MAX_VALUE){
			Set<Integer> o1ArrData = new HashSet<Integer>();
			
			for(int a = 0; a < arrData.length; a++){
				if(target >= 0){
					if(arrData[a] <= target){
						o1ArrData.add(arrData[a]);
					}
				}
				else{
					if(target <= arrData[a]){
						o1ArrData.add(arrData[a]);
					}
				}
			}
			
			for(int a = 0; a < arrData.length; a++){
				int num = target - arrData[a];
				if(o1ArrData.contains(num)){
					twoSum[0] = arrData[a];
					twoSum[1] = num;
					break;
				}
			}
		}
		return twoSum;
	}
}
