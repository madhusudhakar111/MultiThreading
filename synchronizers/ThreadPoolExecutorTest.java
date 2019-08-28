package synchronizers;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {
	public static void main(String[] args) throws Exception {
		
		 BlockingQueue queue = new ArrayBlockingQueue(1);

		 //RejectedExecutionHandler handler = new CallerRunsPolicy();
		// RejectedExecutionHandler handler = new DiscardPolicy ();
		
		RejectedExecutionHandler handler = new DiscardOldestPolicy();
				
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, queue, handler);
		for (int i = 1; i <= 20; i++) {
			pool.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println("Thread Name >>" + Thread.currentThread().getName());
				}
			});
		}
		pool.shutdown();
	}

}
