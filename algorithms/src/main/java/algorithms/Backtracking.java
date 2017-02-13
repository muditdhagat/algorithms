package algorithms;

public class Backtracking {

	public static void main(String[] args) {
		
		String str = "ABC";
		permute(str.toCharArray(), 0, str.length() - 1);

	}
	
	public static void permute(char[] str, int startIndex, int endIndex) {
		
		if(startIndex == endIndex) {
			System.out.println(String.valueOf(str));
		}
		
		else {
			
			for(int i = startIndex; i<=endIndex; i++) {
				swap(str, startIndex, i);
				permute(str, startIndex + 1, endIndex);
				swap(str, startIndex, i); 	
			}
			
		}
		
	}
	
	public static void swap(char[] str, int sourceIndex, int destIndex) {
		char temp = str[sourceIndex];
		str[sourceIndex] = str[destIndex];
		str[destIndex] = temp;
	}

}
