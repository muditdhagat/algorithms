package threads;

public class ThreadBasic {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.printf("%s is %salive and in %s state and priority %d \n", 
				Thread.currentThread().getName(), 
				Thread.currentThread().isAlive() ? "" : "not ", 
				Thread.currentThread().getState(), 
				Thread.currentThread().getPriority());
		
		Runnable r = () -> System.out.printf("%s is %salive and in %s state and priority %d \n", 
				Thread.currentThread().getName(), 
				Thread.currentThread().isAlive() ? "" : "not ", 
				Thread.currentThread().getState(), 
				Thread.currentThread().getPriority());
		
		Thread t = new Thread(r, "My Runnable Thread");
		
		Thread t2 = new Thread("My Normal Thread");
		
		System.out.printf("%s is %salive and in %s state and priority %d \n", 
				t2.getName(), 
				t2.isAlive() ? "" : "not ", 
				t2.getState(), 
				t2.getPriority());
		
		t2.start();
		t.start();
		
		Thread.sleep(2000);
		
	}

}
