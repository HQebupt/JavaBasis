package org.hq.java.lesson7.producerConsumer.blockingqueue;

import java.util.concurrent.BlockingQueue;

/*
 * Usage example, based on a typical producer-consumer scenario.
 * Note that a <tt>BlockingQueue</tt> can safely be used with multiple
 * producers and multiple consumers.
 * <pre>
 */
public class Producer implements Runnable, BufferPool {
	private final BlockingQueue<Object> queue;

	Producer(BlockingQueue<Object> q) {
		queue = q;
	}

	public void run() {
		try {
			while (true) {
				if (queue.size() < BufferPool.BUFPOOL) {
					queue.put(produce());
					Thread.sleep(1);
					System.out.println("+1 Produce an Object:" + "缓存池队列的大小:"
							+ queue.size());
				} else {
					System.out.println("缓存池满了,大小:" + queue.size());
				}
			}
		} catch (InterruptedException ex) {
			System.out.println("生产者线程结束!");
		}
	}

	/**
	 * 生产新对象
	 */
	Object produce() {
		return new Object();
	}
}
