package org.hq.java.lesson6.simple;

public class Main {

    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(new RunnableClass());
        thread1.start();

        Thread thread2 = new ThreadClass();
        thread1.currentThread().sleep(1000);//这样可以让他们顺序打印，因为时间不一样。
        thread2.start();

        thread1.currentThread().sleep(1000);//线程1、2几乎是同时启动的，同时睡觉、同时出现，让JVM来调度。
        thread2.interrupt();
        while (true) {
            try {
                System.out.println("3 :Main.");
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
