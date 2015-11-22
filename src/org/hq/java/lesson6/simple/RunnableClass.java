package org.hq.java.lesson6.simple;

public class RunnableClass implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("1:Runnalbe.");
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("I am dying" + ":" + this.getClass().getSimpleName());
                e.printStackTrace();
                break;
            }
        }
    }

}
