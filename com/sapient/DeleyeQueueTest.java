package com.sapient;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DeleyeQueueTest implements Delayed {

	private String name;
	private long time;

	// Contructor of DelayObject
	public DeleyeQueueTest(String name, long delayTime) {
		this.name = name;
		this.time = delayTime;
	}

	// Implementing getDelay() method of Delayed
	@Override
	public long getDelay(TimeUnit unit) {
			return unit.convert(time, TimeUnit.DAYS);
	}

	// Implementing compareTo() method of Delayed
	@Override
	public int compareTo(Delayed obj) {
		if (this.time < ((DeleyeQueueTest) obj).time) {
			return -1;
		}
		if (this.time > ((DeleyeQueueTest) obj).time) {
			return 1;
		}
		return 0;
	}

	// Implementing toString() method of Delayed
	@Override
	public String toString() {
		return "\n{" + "name=" + name + ", time=" + time + "}";
	}

	public static void main(String[] args) {

		BlockingQueue<DeleyeQueueTest> DQ = new DelayQueue<DeleyeQueueTest>();

		// Add numbers to end of DelayQueue
		DQ.add(new DeleyeQueueTest("A", 1));
		DQ.add(new DeleyeQueueTest("B", 2));
		DQ.add(new DeleyeQueueTest("D", 4));
		DQ.add(new DeleyeQueueTest("C", 3));

		// print Dequee
		System.out.println("DelayQueue: " + DQ);

		// create object of DelayQueue
		// using DelayQueue(Collection c) constructor
		BlockingQueue<DeleyeQueueTest> DQ2 = new DelayQueue<DeleyeQueueTest>(DQ);

		// print Dequee
		System.out.println("DelayQueue: " + DQ2);

	}

}
