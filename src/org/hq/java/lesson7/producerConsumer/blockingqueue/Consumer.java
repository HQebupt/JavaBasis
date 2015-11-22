package org.hq.java.lesson7.producerConsumer.blockingqueue;

import java.util.concurrent.BlockingQueue;

class Consumer implements Runnable {
    private final BlockingQueue<Object> queue;

    Consumer(BlockingQueue<Object> q) {
        queue = q;
    }

    public void run() {
        try {
            while (true) {
                consume(queue.take());
                Thread.sleep(10);
                System.out.println("-1 Consumer an Object:" + "缓存池的大小:" + queue.size());
            }
        } catch (InterruptedException ex) {
            System.out.println("消费者结束.");
        }
    }

    /**
     * 消费一个对象
     */
    void consume(Object obj) {
    }
}
