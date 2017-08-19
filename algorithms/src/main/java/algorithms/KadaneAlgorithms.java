package algorithms;

public class KadaneAlgorithms {
	
	public static int maxSubArray(int[] array) {
		
		int maxOverall = Integer.MIN_VALUE;
		int maxTemp = 0;
		
		for(int item : array) {
			
			maxTemp = maxTemp + item;
			if(maxOverall < maxTemp) {
				maxOverall = maxTemp;
			}
			if(maxTemp < 0) {
				maxTemp = 0;
			}
		}
		return maxOverall;
	}

	public static void main(String[] args) {
		
		int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                                       maxSubArray(a));
		

	}

}
