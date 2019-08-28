package synchronizers;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TransferQueue;

public class Test {

	Test() {
		System.out.println("Calling construcctor");
	}

	static final int data; // static blank final variable
	static {
		System.out.println(" static block");
		data = 50;
	}

	
	{
		System.out.println(" Initializing Block ");
		
	}
	public static void main(String args[]) {
	//	Test.data = 100;
	//	System.out.println(Test.data);
		Test t = new Test();
		
	//TransferQueue<E>	
		
		int a = 1;
		int b = 2;

		a++;
		b++;
		
			}

}
