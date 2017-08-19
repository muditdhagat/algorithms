package algorithms;

import java.util.Scanner;

public class MissingNumber {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		
		while(t > 0) {
			int n = scanner.nextInt();
			// Create a new array 
			int array[] = new int[n - 1];
			
			for(int i = 0; i < n - 1; i++) {
				array[i] = scanner.nextInt();
			}
			
			// Perform the function
			System.out.println(missingNumber(array, n));
			
			t--;
		}
		
		scanner.close();
		
	}
	
	public static int missingNumber(int array[], int n) {
		// Values range 
		for(int i = 1; i <= n; i++) {
			for(int number : array) {
//				if()
			}
		}
		
		return 0;
	}

}
