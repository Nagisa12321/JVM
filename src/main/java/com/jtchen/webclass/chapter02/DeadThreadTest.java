package com.jtchen.webclass.chapter02;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/20 16:47
 */
public class DeadThreadTest {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println("start");
            new DeadThread();
            System.out.println("end");
        };

        Thread t1 = new Thread(r, "�߳�1");
        Thread t2 = new Thread(r, "�߳�2");

        t1.start();
        t2.start();
    }

    private static class DeadThread {
        static {
            Thread thread = Thread.currentThread();
            System.out.println("DeadThread �Ѿ���" + thread.getName() + "����");
            while (true) {
                if (false) break;
            }
        }
    }
}
