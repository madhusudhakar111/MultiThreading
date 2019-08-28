package concurency.completableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CompletableFutureExample {
	
	private void runAsync() throws InterruptedException, ExecutionException {
		
		CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
		    @Override
		    public void run() {
		    	try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		        System.out.println("I'll run in a separate thread than the main thread.");
		    }
		});
		future.get();
	}
	
	private Integer getNumber(int number) {
		return number;
	}
	
	private void supplyAsync() throws InterruptedException, ExecutionException {
		
		ExecutorService executor = Executors.newFixedThreadPool(10);
		AtomicInteger integer = new AtomicInteger(0);
		List<CompletableFuture> taskList = new ArrayList();
		
		for(int i=0; i<10;i++ ) {
		taskList.add(
					CompletableFuture.supplyAsync(
							() -> { return getNumber(integer.incrementAndGet())+""; }, 	executor)
			   );
		}
						
		for(CompletableFuture future: taskList) {
			System.out.println(future.get());
		}
		
		executor.shutdown();
	}
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		
		CompletableFutureExample obj = new CompletableFutureExample();
		
		//obj.runAsync();
		obj.supplyAsync();
	
		
	}
	
	
}
