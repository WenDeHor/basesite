package com.base.network;

import java.util.ArrayList;
import java.util.List;

public class MainCancarency {
    public static final int INT = 10000;
    private static int count;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + ", " + getState());
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ", " + Thread.currentThread().getState());
            }
        }).start();

        final MainCancarency mainCancarency = new MainCancarency();
        List<Thread> threadList = new ArrayList<>(INT);
        for (int i = 0; i < INT; i++) {
            final Thread thread = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    mainCancarency.inc();
                }
            });
            thread.start();
            threadList.add(thread);
//            thread.join();
        }
//        Thread.sleep(500);
        threadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(count);
    }

    private synchronized void inc() {
//        synchronized (this) {
//        synchronized (MainCancarency.class) {
//        notifyAll();
        count++;
    }
//     }
//    }
}
