package threads;


public class ThreadWaitNotify {

	public static void main(String[] args) {

		long total = 0;

		WorkThread th = new WorkThread(0, total);
		
	}

}

class WorkThread extends Thread {

	int numbers;
	long total;

	public WorkThread(int numbers, long total) {
		this.numbers = numbers;
		this.total = total;
	}

	@Override
	public void run() {

		for(int i = 0; i<numbers; i++) {
			for(int m = 1; m<numbers; i++) {
				total += m;
			}
		}

	}

}

