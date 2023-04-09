package Collections;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrListEx extends Thread {

	static CopyOnWriteArrayList<String> l = new CopyOnWriteArrayList<String>();

	public void run() {
		// Child thread trying to
		// add new element in the
		// Collection object
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread modifying list with element 'D' !!!");
		l.add("D");
	}

	public static void main(String[] args) throws InterruptedException {
		l.add("A");
		l.add("B");
		l.add("c");

		// We create a child thread
		// that is going to modify
		// ArrayList l.
		CopyOnWriteArrListEx t = new CopyOnWriteArrListEx();
		t.start();

		// Now we iterate through
		// the ArrayList and get
		// exception.
		System.out.println("Start iterating over list");
		Iterator<String> itr = l.iterator();
		while (itr.hasNext()) {
			String s = itr.next();
			System.out.println(s);
			Thread.sleep(1000);
		}
		System.out.println(l);
	}
}
