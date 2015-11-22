package org.hq.java.lesson7.producerConsumer.lock;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** 缓存池采用"LinkedList",生产者消费者用"Lock" 和 "Condition" 来控制缓存池.
 * @author HuangQiang
 * @file ProducerConsumer.java
 */
public class ProducerConsumer {
    private static final LinkedList<Object> buffer = new LinkedList<Object>();
    private static final int BUFFERSIZE = 10;
    private static Lock lock = new ReentrantLock();// 可重用的互斥锁
    private static Condition NotFull = lock.newCondition();
    private static Condition NotEmpty = lock.newCondition();

    static class Producer extends Thread {
        public void run() {
            while (true) {
                // lock
                lock.lock();
                if (buffer.size() == BUFFERSIZE) {
                    System.out.println("Buffer is fulls");
                    try {
                        NotFull.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    buffer.addLast(new Object());
                    NotEmpty.signal();
                }
                lock.unlock();
                // unlock
            }
        }
    }

    static class Consumer extends Thread {
        public void run() {
            while (true) {
                // lock
                lock.lock();
                if (buffer.size() == 0) {
                    System.out.println("Buffer is empty");
                    try {
                        NotEmpty.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    buffer.removeFirst();
                    NotFull.signal();
                }
                // unlock
                lock.unlock();
            }
        }
    }

    /**
     * 1个生产者,1个消费者
     */
    public static void main(String[] args) {
        new Consumer().start();
        new Producer().start();
    }
}
