package threadssync;

public class UniqueIDGenerator {
	
	public static int id = 1;
	
	public static int generateId() {
		return id++;
	}

	public static void main(String[] args) {
		
		Runnable r = () -> System.out.printf("%s: My Id is %d\n", Thread.currentThread().getName(), generateId());
		Thread t1 = new Thread(r, "First");
		t1.start();
		Thread t2 = new Thread(r, "Second");
		t2.start();
		Thread t3 = new Thread(r, "Thrid");
		t3.start();
		
	}
	
	
	
	
}
