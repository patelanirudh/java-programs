package Threads;

public class Geek2 extends Thread {
	private Geek1 geesk1Object;

	public Geek2(Geek1 obj) {
		this.geesk1Object = obj;
	}

	@Override
	public void run() {

		synchronized (this.geesk1Object) {
			try {
				System.out.println(Thread.currentThread().getName() + "...Geek2 starts");
				Thread.sleep(1500);
				this.geesk1Object.wait(); // --> release the lock on monitor object
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
}