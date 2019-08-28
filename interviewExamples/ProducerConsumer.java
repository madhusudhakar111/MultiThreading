package interviewExamples;

import java.util.LinkedList;

public class ProducerConsumer {

	LinkedList<Integer> lst;

	public ProducerConsumer(LinkedList<Integer> lst) {
		super();
		this.lst = lst;
	}

	public void produce() throws InterruptedException {

		synchronized (lst) {

			while (true) {

				if (lst.size() == 2) {
					lst.wait();
				}

				lst.add(1);
				lst.add(2);

				System.out.println("Producer List >>>>> " + lst);
				lst.notify();
			}
		}
	}

	public void consumer() throws InterruptedException {

		synchronized (lst) {

			while (true) {

				if (lst.size() < 2) {
					lst.wait();
				}

				System.out.println("Consuer  List 1 index >>>>> " + lst.remove());
				System.out.println("Consuer List 1 index >>>>> " + lst.remove());

				lst.notify();
			}

		}

	}
	
	public static void main(String[] args) throws InterruptedException {

		ProducerConsumer pc = new ProducerConsumer(new LinkedList());

		Thread t1 = new Thread() {

			public void run() {

				try {
					pc.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		};

		Thread t2 = new Thread() {

			public void run() {

				try {
					pc.consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		};
		
		t1.setName(" T1 ");		
		t2.setName(" T2 ");	
		
		
		t1.start();
			
		t2.start();
		
		

	}

}