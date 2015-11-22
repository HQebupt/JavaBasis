package org.hq.java.lesson6.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {

    public static int i = 1;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            exec.execute(new MyRunnable());// 一次提交了5个线程，2个线程在排队。
        }
        exec.shutdown();// 关掉线程池。
    }

    static class MyRunnable implements Runnable {
        private int id = i++;

        public void run() {
            for (int j = 0; j < 10; j++)
                System.out.println(id + " : " + j);
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
