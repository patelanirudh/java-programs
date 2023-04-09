package Threads;

public class Geek1 extends Thread {

	@Override
	public void run() {

		synchronized (this) {
			try {
				System.out.println(Thread.currentThread().getName() + "...Geek1 starts");
				wait(); // --> release the lock on monitor object
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// monitor object lock acquired
			System.out.println(Thread.currentThread().getName() + "... notified");
			try {
				System.out.println(Thread.currentThread().getName() + "... sleeping");
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	public static void main(String[] args) throws InterruptedException {
		Geek1 obj1 = new Geek1();
		Geek2 obj2 = new Geek2(obj1);
		Geek3 obj3 = new Geek3(obj1);
		
		// which ever thread waits first gets the lock resource first on being notified
		// swap obj1.start() and obj2.start() to verify
		obj2.start(); 
		obj1.start();
		// start notifier thread late so that each waiting threads could perform : lock -> wait() -> release lock
		Thread.sleep(2000);
		obj3.start();
	}
}
