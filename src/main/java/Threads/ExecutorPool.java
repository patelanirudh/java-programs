package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorPool implements Runnable {

	private int id;

	public ExecutorPool(int i) {
		id = i;
	}

	@Override
	public void run() {
		System.out.println("Task started : " + id);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Task " + id + " completed");

	}

	public static void main(String[] args) {
		ExecutorService executorPool = Executors.newFixedThreadPool(2);

		for (int i = 0; i < 5; ++i) {
			// 2 worker threads each taking a task
			executorPool.submit(new ExecutorPool(i)); 
		}

		executorPool.shutdown();

		System.out.println("All tasks has been submitted");
		// even without adding awaitTermination executorPool completed all prior
		// submitted tasks

		try {
			executorPool.awaitTermination(15, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("All tasks have been completed");
	}
}
