package Threads;

import java.util.LinkedList;

public class ProducerConsumer {

	private LinkedList<Integer> dataList = new LinkedList<>();
	private static final int MAX_SIZE = 5;
	private int value = 0;

	public void produce() throws InterruptedException {
		while (true) {
			synchronized (this) {

				// 'if' check can be used, but we should make sure to test the initial
				// condition once after resuming from wait()
				while (dataList.size() == MAX_SIZE) {
					System.out.println(Thread.currentThread().getName() + " waiting for consumer to consume...");
					this.wait(); // release lock
				}

				System.out.println(Thread.currentThread().getName() + " producing ......");
				dataList.add(value++);
				this.notify();
			}
		}
	}

	public void consume() throws InterruptedException {
		synchronized (this) {
			while (true) {
				// 'if' check can be used, but we should make sure to test the initial
				// condition once after resuming from wait()
				while (dataList.size() == 0) {
					System.out.println(Thread.currentThread().getName() + " waiting for producer to produce...");
					this.wait(); // release lock
				}

				Thread.sleep(900);
				int value = dataList.removeFirst();
				System.out.println(Thread.currentThread().getName() + " value remove from list " + value
						+ ", list size = " + dataList.size());

				this.notify();
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {

		ProducerConsumer object = new ProducerConsumer();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// this == object

				try {
					object.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.setName("ProducerTh-");

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				// this == object
				try {
					object.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t2.setName("ConsumerTh-");

		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}

}
