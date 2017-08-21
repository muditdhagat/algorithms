package string;

public class WordCount {
	
	public static int[] getWordCount(String in) {
		int[] wordcount = new int[26];
		
		for(int i = 0; i < in.length(); i++) {
			char ch = in.charAt(i);
			wordcount[ch - 'a'] += 1;
		}

		return wordcount;
	}
	
	public static void main(String[] args) {
		int[] wordcount = getWordCount("muditdhagat");
		for(int i = 0; i<26; i++) {
			System.out.print((char)(i + 'a'));
			System.out.println(wordcount[i]);
		}
	}

}
