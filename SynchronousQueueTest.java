package com.sapient;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {

	public static void main(String[] args) {

		final SynchronousQueue<String> queue = new SynchronousQueue<String>();
		
		
		Thread producer = new Thread() {
			public void run() {
				try {
					queue.put("Helloworld");
					System.out.println(" Helloworld ---> ");
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		producer.start();
		
		try {
			String str = queue.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
