package com.sapient;

import java.time.LocalDate;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueTest {

	public static void main(String[] args) {

		PriorityBlockingQueue<Employee> queue = new PriorityBlockingQueue<>();

		queue.add(new Employee(1l, "AAA", LocalDate.now()));
		queue.add(new Employee(4l, "CCC", LocalDate.now()));
		queue.add(new Employee(5l, "BBB", LocalDate.now()));
		queue.add(new Employee(2l, "FFF", LocalDate.now()));
		queue.add(new Employee(3l, "DDD", LocalDate.now()));

		while (true) {

			Employee e = queue.poll();
			System.out.println(e);

			if (e == null)
				break;
		}

	}

}
