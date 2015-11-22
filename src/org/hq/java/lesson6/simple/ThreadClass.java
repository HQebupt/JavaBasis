package org.hq.java.lesson6.simple;

public class ThreadClass extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("2:Thread!");
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("I am dying" + ":" + this.getClass().getSimpleName());
                // e.printStackTrace();
                break;
            }
        }
    }
}
