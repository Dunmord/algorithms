import java.util.HashSet;
import java.util.Set;

public class TwoSum {
	
	public TwoSum(){
	}
	
	public int[] calculate(int[] arrData, int target){
		int[] twoSum = new int[2];
		if(target < Integer.MAX_VALUE){
			Set<Integer> o1ArrData = new HashSet<Integer>();
			
			for(int a = 0; a < arrData.length; a++){
				if(arrData[a] <= target){
					o1ArrData.add(arrData[a]);
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
