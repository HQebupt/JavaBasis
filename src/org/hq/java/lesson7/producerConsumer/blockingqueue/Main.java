package org.hq.java.lesson7.producerConsumer.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
class Main {
	/**
	 * 1个生产者,2个消费者
	 */
	public static void main(String[] args) {
		BlockingQueue<Object> q = new LinkedBlockingQueue<Object>();// SomeQueueImplementation();
		Producer p = new Producer(q);
		Consumer c1 = new Consumer(q);
		Consumer c2 = new Consumer(q);
		Thread pth = new Thread(p);
		pth.start();
		new Thread(c1).start();
		new Thread(c2).start();
		try {
			Thread.sleep(50);
			pth.interrupt();
		} catch (InterruptedException e) {
		}
	}
}