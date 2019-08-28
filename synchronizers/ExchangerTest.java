package synchronizers;

import java.util.concurrent.Exchanger;

public class ExchangerTest implements Runnable {

	Exchanger exchanger = null;
	Object object = null;

	public ExchangerTest(Exchanger exchanger, Object object) {
		this.exchanger = exchanger;
		this.object = object;
	}

	public void run() {
		try {
			Object previous = this.object;
			this.object = this.exchanger.exchange(this.object);
			System.out.println(Thread.currentThread().getName() + " exchanged " + previous + " for " + this.object);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Exchanger exchanger = new Exchanger();

		ExchangerTest exchangerRunnable1 = new ExchangerTest(exchanger, "A");

		ExchangerTest exchangerRunnable2 = new ExchangerTest(exchanger, "B");

		new Thread(exchangerRunnable1).start();
		new Thread(exchangerRunnable2).start();

	}

}
