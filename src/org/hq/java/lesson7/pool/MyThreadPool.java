package org.hq.java.lesson7.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool {
    static BlockingQueue<Runnable> queue; //需要执行的任务Task
    List<Thread> threads; // 线程池资源,用List来存储,提前初始化好

    // 线程池的初始化
    MyThreadPool(int threadNum) {
        MyThreadPool.queue = new LinkedBlockingQueue<Runnable>();
        this.threads = new ArrayList<Thread>(threadNum);
        for (int i = 0; i < threadNum; i++) {
            Thread t = new InnerThread();
            t.start();
            threads.add(t);
        }
    }

    // 设计思路:利用while死循环来控制线程的启动.
    // 注意:while(true)的位置在try里面,保证可以中断线程,方便后面的shutdown方法.
    static class InnerThread extends Thread {
        public void run() {
            System.out.println("InnerThread is running.");
            try {
                while (true) {
                    queue.take().run();
                }
            } catch (InterruptedException e) {
                System.out.println("One thread is dying!");
            }
        }
    }

    void execute(Runnable task) {
        queue.add(task);
    }

    void shutdown() {
        for (Thread t : threads) {
            t.interrupt();
        }
    }
}
