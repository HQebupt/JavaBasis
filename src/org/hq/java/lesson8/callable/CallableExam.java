package org.hq.java.lesson8.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExam {
    public static void main(String args[]) throws Exception {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        // Executors的源码够大家看一段时间了
        //Effective Java的第一章-会涉及到Executors的静态工厂，设计得很巧妙。
        Future<String> result1 = threadPool.submit(new InnerTask1());
        Future<Integer> result2 = threadPool.submit(new InnerTask2());
        System.out.println(result1.get());
        System.out.println(result2.get());

    }

    static class InnerTask1 implements Callable<String> {
        public String call() throws Exception {
            return "zengjingsong is not late today";
        }
    }

    static class InnerTask2 implements Callable<Integer> {

        public Integer call() throws Exception {
            Thread.currentThread().sleep(4000);
            return 1 + 1;
        }
    }
}
