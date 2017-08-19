package util;

import java.util.Scanner;

public class InputReader {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		
		while(t > 0) {
			int n = scanner.nextInt();
			// Create a new array 
			int array[] = new int[n];
			
			for(int i = 0; i < n; i++) {
				array[i] = scanner.nextInt();
			}
			
			// Perform the function
			System.out.println("Funcation Result");
			
			t--;
		}
		
		scanner.close();
	}

}
