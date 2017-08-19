package recursion;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		
		int[] coinArray = {1, 2, 3};
		int amount = 5;
		
		int numberOfWays = calculateCount(coinArray, coinArray.length, amount);
		System.out.println("Number of Ways: " + numberOfWays);

		numberOfWays = calculateCountDynamic(coinArray, coinArray.length, amount);
		System.out.println("Number of Ways: " + numberOfWays);
	}
	
	public static int calculateCount(int coinArray[], int numberOfCoins, int amount) {
		
		if(amount == 0) {
			return 1;
		}
		
		if(amount < 0) {
			return 0;
		}
		
		if(numberOfCoins <= 0 && amount >= 1) {
			return 0;
		}
		
		return calculateCount(coinArray, numberOfCoins - 1, amount) + calculateCount(coinArray, numberOfCoins, amount - coinArray[numberOfCoins - 1]);
	}
	
	public static int calculateCountDynamic(int coinArray[], int numberofCoins, int amount) {
		// Create a table for all amounts including zero to amount
		int[] tbl = new int[amount + 1];
		 // Initialize all table values as 0
        Arrays.fill(tbl, 0);
        // If given amount is zero, we have 1 as the solution
        tbl[0] = 1;
        // Pick all coins one by one 
        for (int i = 0; i<numberofCoins; i++) {
        	for (int j = coinArray[i]; j<=amount; j++) {
        		tbl[j] += tbl[j - coinArray[i]];
        	}
        }
        return tbl[amount];
	}

}
