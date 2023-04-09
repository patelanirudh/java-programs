package Threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CntDwnLatch extends Thread {
	private CountDownLatch latch;
	private String name;

	public CntDwnLatch(CountDownLatch lat, String name) {
		this.latch = lat;
		this.name = name;
	}

	@Override
	public void run() {

		System.out.println(name + " working on task");
		try {
			// some work
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + " completed task... down counting latch");
		latch.countDown();

	}

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(5);

		ExecutorService service = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			service.submit(new CntDwnLatch(latch, "Thread-" + i));
		}

		System.out.println("Waiting for workers to complete their work");
		latch.await(); // waits till worker count == 0
		System.out.println("All workers have completed their work");

		service.shutdown();
	}
}
