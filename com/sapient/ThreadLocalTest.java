package com.sapient;

public class ThreadLocalTest {

	private ThreadLocal<Integer> threadlocal = new ThreadLocal<>();

	private void test(int number) {
		threadlocal.set(number);
		System.out.println(Thread.currentThread().getName() + "  >>>>> " + threadlocal.get());
	}

	public static void main(String[] args) {

		ThreadLocalTest threadLocalTest = new ThreadLocalTest();

		Thread t1 = new Thread() {
			@Override
			public void run() {
				threadLocalTest.test(10);
			}

		};

		Thread t2 = new Thread() {
			@Override
			public void run() {
				threadLocalTest.test(20);
			}

		};

		Thread t3 = new Thread() {
			@Override
			public void run() {
				threadLocalTest.test(30);
			}

		};

		Thread t4 = new Thread() {
			@Override
			public void run() {
				threadLocalTest.test(40);
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

	}

}
