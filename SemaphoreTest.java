package com.sapient;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	public void test(Semaphore semaphore) {

		try {
			semaphore.acquire();
			System.out.println("Hello world + >>" + Thread.currentThread().getName() + " Lock Acruired");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		semaphore.release();
		System.out.println("Hello world + >>" + Thread.currentThread().getName() + " Lock Released");

	}

	public static void main(String[] args) {

		Semaphore semaphore = new Semaphore(2);

		SemaphoreTest SemaphoreTest = new SemaphoreTest();

		Thread t1 = new Thread() {
			public void run() {
				SemaphoreTest.test(semaphore);
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				SemaphoreTest.test(semaphore);
			}
		};

		Thread t3 = new Thread() {
			public void run() {
				SemaphoreTest.test(semaphore);
			}
		};
		Thread t4 = new Thread() {
			public void run() {
				SemaphoreTest.test(semaphore);
			}
		};
		Thread t5 = new Thread() {
			public void run() {
				SemaphoreTest.test(semaphore);
			}
		};
		
		
		t1.start();
		t1.setName("T1");
		t2.start();
		t2.setName("T2");
		t3.start();
		t3.setName("T3");
		t4.start();
		t4.setName("T4");
		
		t5.start();
		t5.setName("T5");

	}

}
