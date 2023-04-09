package Threads;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockAPI extends Thread {

	private Random random = new Random();
	public List<Integer> list1 = new LinkedList<>();
	public List<Integer> list2 = new LinkedList<>();
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();

	public void workOnList1() {
		lock1.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " acquired lock and working");
			list1.add(random.nextInt());
			Thread.sleep(1);
		} catch (Exception e) {

		} finally {
			System.out.println(Thread.currentThread().getName() + " releasing lock");
			lock1.unlock();
		}
	}

	public void workOnList2() {
		lock2.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " acquired lock and working");
			list2.add(random.nextInt());
			Thread.sleep(1);
		} catch (Exception e) {

		} finally {
			System.out.println(Thread.currentThread().getName() + " releasing lock");
			lock2.unlock();
		}
	}


	@Override
	public void run() {
		// If you want thread dedicated to each function
		// Check thread name and then call ListX method.
		// If thread == A; i = 0; i<500; i++; workOnList1()

		// No 2 threads can work on the same function but they will not
		// block once they are working in separate functions as there are
		// individual Locks available
		for (int i = 0; i < 5; i++) {
			workOnList1();
			workOnList2();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		LockAPI lobject = new LockAPI();

		Thread t1 = new Thread(lobject);
		Thread t2 = new Thread(lobject);

		t1.start();
		t2.start();

		t1.join();
		t2.join();
		System.out.println("List1 size " + lobject.list1.size() + ", List2 size " + lobject.list2.size());
	}

}
