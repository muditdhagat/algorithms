package threads;

public class ThreadJoin {

	public static void main(String[] args) throws InterruptedException {
		WorkerThread th1 = new WorkerThread("Worker-1");
		WorkerThread th2 = new WorkerThread("WorkerThread-2");
		
		th1.start();
		th2.start();
		
		th1.join();
		th2.join();
	}

}
