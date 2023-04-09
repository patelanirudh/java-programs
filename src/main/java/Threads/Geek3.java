package Threads;

public class Geek3 extends Thread {
	private Geek1 geesk1Object;

	public Geek3(Geek1 obj) {
		this.geesk1Object = obj;
	}

	@Override
	public void run() {

		synchronized (this.geesk1Object) {
			System.out.println(Thread.currentThread().getName() + "... starts");
			this.geesk1Object.notifyAll(); // --> monitor object lock is not released at this point
			System.out.println(Thread.currentThread().getName() + "... notified all !!!");
			try {
				System.out.println(Thread.currentThread().getName() + "... sleeping");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // now object monitor lock released
	}
}