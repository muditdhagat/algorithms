package string;

public class Palindrome {
	
	public static boolean isPalindrome(String in) {
		int s = 0;
		int e = in.length() - 1;
		
		while(e > s) {
			if(in.charAt(s) != in.charAt(e)) return false;
			s++; e--;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("abbba"));
	}

}
