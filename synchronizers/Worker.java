package synchronizers;
import java.util.concurrent.CountDownLatch;

//A class to represent threads for which 
//the main thread waits. 
public class Worker extends Thread {
	private int delay;
	private CountDownLatch latch;

	public Worker(int delay, CountDownLatch latch, String name) {
		super(name);
		this.delay = delay;
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() );
				latch.countDown();
		
		
	}
}