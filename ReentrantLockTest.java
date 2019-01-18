package com.sapient;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

	public void test(ReentrantLock lock) {

		/*
		 * try {
		 * 
		 * lock.lock(); System.out.println(Thread.currentThread().getName() +
		 * "   Lock Acruired"); Thread.sleep(1000); lock.unlock();
		 * System.out.println(Thread.currentThread().getName() + "   Lock Released"); }
		 * catch (Exception e) { e.printStackTrace(); }
		 * 
		 */

		/*
		 * if (lock.tryLock()) {
		 * 
		 * try {
		 * 
		 * 
		 * System.out.println(Thread.currentThread().getName() + "   Lock Acruired");
		 * Thread.sleep(1000); lock.unlock();
		 * System.out.println(Thread.currentThread().getName() + "   Lock Released"); }
		 * catch (Exception e) { e.printStackTrace(); } } else {
		 * 
		 * System.out.println(Thread.currentThread().getName() + " has been Locked"); }
		 */

		try {

			if (lock.tryLock(5000, TimeUnit.MILLISECONDS)) {

				try {
					
					System.out.println(Thread.currentThread().getName() + "   Lock Acruired");
					Thread.sleep(1000);
					lock.unlock();
					System.out.println(Thread.currentThread().getName() + "   Lock Released");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("Else Block ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		ReentrantLock lock = new ReentrantLock();
		ReentrantLockTest test = new ReentrantLockTest();

		for (int i = 0; i < 20; i++) {

			Thread t = new Thread() {
				@Override
				public void run() {
					test.test(lock);
				}

			};
			t.start();

		}
	}

}
