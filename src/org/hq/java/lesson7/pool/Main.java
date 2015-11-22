package org.hq.java.lesson7.pool;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static List<Integer> block = new LinkedList<Integer>();

    static {
        block = Collections.synchronizedList(block);
        for (int i = 0; i < 1500; i++) {
            block.add(i);
        }
    }

    /**
     * InnerWork
     *
     * @author HuangQiang
     * @file Main.java
     */
    static class InnerWork implements Runnable {
        String name;

        public InnerWork(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++)
                System.out.println(name + " :  " + block.remove(0));
        }
    }

    public static void main(String[] args) throws Exception {
        // Java自带的线程池
        // ExecutorService threadPool = Executors.newFixedThreadPool(2);
        MyThreadPool threadPool = new MyThreadPool(2);
        for (int i = 0; i < 10; i++)
            threadPool.execute(new InnerWork(i + ""));
        Thread.currentThread().sleep(1000);
        threadPool.shutdown();
    }
}
