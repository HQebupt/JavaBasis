package org.hq.java.lesson7.sync;

import java.util.ArrayList;

public class Account {
    private int money;

    public Account(int money) {
        this.money = money;
    }

    // 方法上:this引用
    public synchronized void saveMoney(int money) {
        this.money += money;
    }

    public synchronized void getMoney(int money) {
        this.money -= money;
    }

    public synchronized int showMoney() {
        return money;
    }

    static class SaveThread extends Thread {
        Account account;
        static Integer code = 100;

        public SaveThread(Account account) {
            this.account = account;
        }

        /**
         * 存钱50次,取钱50次
         */
        @SuppressWarnings("static-access")
        public void run() {
            for (int i = 0; i < 50; i++) {
                // 代码块:指定的对象
                synchronized (code) {
                    code++;
                }
                account.saveMoney(1000);
                System.out.println("save time:" + i + " code:" + code);
                try {
                    Thread.currentThread().sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 50; i++) {
                // 代码块:指定的对象
                synchronized (code) {
                    code--;
                }
                account.getMoney(1000);
                System.out.println("get time:" + i + " code:" + code);
                try {
                    Thread.currentThread().sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 对同一个账户,进行多线程存钱和取钱.查看最后账户的钱是否是正确的.
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Account account = new Account(1000);
        System.out.println("账户初始 money:" + account.showMoney());
        ArrayList<SaveThread> st = new ArrayList<SaveThread>();
        for (int i = 0; i < 2; i++) {
            st.add(new SaveThread(account));
            st.get(i).start();
        }
        Thread.currentThread().sleep(1000);
        System.out.println("账户结束 money:" + account.showMoney());
    }
}
