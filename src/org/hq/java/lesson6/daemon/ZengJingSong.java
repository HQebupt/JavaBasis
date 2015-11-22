package org.hq.java.lesson6.daemon;

public class ZengJingSong extends Thread {

    public void run() {
        String line = "i am sleeping happliy";
        while (true) {
            try {
                System.out.println("waiting for zhangtao: " + line);
                Thread.currentThread().sleep(3000);

            } catch (InterruptedException e) {
                line = "i don't give a shit, i am still sleeping.";
                System.out.println("z:zhangtao is comming");
                System.out.println(line);
                // break;// 张涛来了，他就不睡觉了。
            }
        }
    }

}
