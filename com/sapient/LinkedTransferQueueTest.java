package com.sapient;

import java.util.concurrent.LinkedTransferQueue;

public class LinkedTransferQueueTest {

	public static void main(String[] args) throws InterruptedException {

		LinkedTransferQueue<String> tQueue = new LinkedTransferQueue<String>();		
		
		new Thread(new Runnable() {
			@Override
			public void run() {		
				try {
					System.out.println("transferring an element");
					tQueue.transfer("brand");					
					System.out.println("element transfer is complete");
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
			}			
		}).start();	
		
		try {
			System.out.println("transfer queue received element: "+tQueue.take());
		} catch (Exception e) {
			e.printStackTrace();
		}
        
	}

}
