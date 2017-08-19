package threads;

import recursion.FibonacciSeries;

public class WorkerThread extends Thread {
	
	public WorkerThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		
		// Let's do some work 
		FibonacciSeries s = new FibonacciSeries();
		s.printFibonacciSeries(this.getName().length());
		
	}

}
