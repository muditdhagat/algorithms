package recursion;

public class FibonacciSeries {
	
	int a = 0, b = 1, c;
	
	public void printFibonacciSeries(int n) {
		if(n >= 0) {
			c = a + b;
			System.out.printf(" %d ", c);
			a = b;
			b = c;
			printFibonacciSeries(--n);
		}
	}
	
	public static void main(String[] args) {
		
		FibonacciSeries f = new FibonacciSeries();
		f.printFibonacciSeries(10);
		
	}

}
