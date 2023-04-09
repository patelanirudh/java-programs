package Threads;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SyncMultipleLocks extends Thread {

	private Random random = new Random();
	public List<Integer> list1 = new LinkedList<>();
	public List<Integer> list2 = new LinkedList<>();
	private Object lock1 = new Object();
	private Object lock2 = new Object();

	public void workOnList1() {
		synchronized (lock1) {
			try {
//			System.out.println(Thread.currentThread().getName() + " acquired lock and working");
				list1.add(random.nextInt());
				Thread.sleep(1);
			} catch (Exception e) {

			}
		}
	}

	public void workOnList2() {
		synchronized (lock2) {
			try {
//				System.out.println(Thread.currentThread().getName() + " acquired lock and working");
				list2.add(random.nextInt());
				Thread.sleep(1);
			} catch (Exception e) {
			}
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			workOnList1();
			workOnList2();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		SyncMultipleLocks lobject = new SyncMultipleLocks();
		Thread t1 = new Thread(lobject);
		Thread t2 = new Thread(lobject);

		t1.start();
		t2.start();

		t1.join();
		t2.join();
		System.out.println("List1 size " + lobject.list1.size() + ", List2 size " + lobject.list2.size());
	}

}
