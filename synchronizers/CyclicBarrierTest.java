package synchronizers;


import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest implements Runnable {

	CyclicBarrier barrier = null;	

	public CyclicBarrierTest(CyclicBarrier obj) {
		this.barrier = obj;
	}

	public CyclicBarrierTest() {
	}

	public void run() {
		System.out.println(" Thread Name " + Thread.currentThread().getName());
		try {
			
			 barrier.await();
			 System.out.println(" Thread Name " + Thread.currentThread().getName());
			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println( " Threads Done");
	}

	public static void main(String[] args) throws InterruptedException {

	//	final CyclicBarrier obj = new CyclicBarrier(3);
		
		final CyclicBarrier obj = new CyclicBarrier(3, new Runnable(){
            @Override
            public void run(){
                //This task will be executed once all thread reaches barrier
                System.out.println("All parties are arrived at barrier, lets play");
            }
        });


		
		
		Thread t1 = new Thread(new CyclicBarrierTest(obj));
		t1.setName("Thread A");
		t1.start();

		Thread t2 = new Thread(new CyclicBarrierTest(obj));
		t2.setName("Thread B");
		t2.start();

		Thread.sleep(1000);

		Thread t3 = new Thread(new CyclicBarrierTest(obj));
		t3.setName("Thread C");
		t3.start();
		

		Thread t4 = new Thread(new CyclicBarrierTest(obj));
		t4.setName("Thread D");
		t4.start();
		
		Thread t5 = new Thread(new CyclicBarrierTest(obj));
		t5.setName("Thread E");
		t5.start();
		
		Thread t6 = new Thread(new CyclicBarrierTest(obj));
		t6.setName("Thread E");
		t6.start();
	}

}

