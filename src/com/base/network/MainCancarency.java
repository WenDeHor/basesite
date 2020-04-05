package com.base.network;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainCancarency {
    public static final int INT = 10000;
    private static int count;
    private static final Lock lock = new ReentrantLock();
    private static final AtomicInteger atomicInteger = new AtomicInteger();
    private static final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static final Lock write = reentrantReadWriteLock.writeLock();
    private static final Lock read = reentrantReadWriteLock.readLock();

    private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        }
    };

    public static void main(String[] args) throws InterruptedException {
//        System.out.println(Thread.currentThread().getName());
//        new Thread() {
//            @Override
//            public void run() {
//                System.out.println(getName() + ", " + getState());
//            }
//        }.start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName() + ", " + Thread.currentThread().getState());
//            }
//        }).start();

        //TODO 7

        final MainCancarency mainCancarency = new MainCancarency();
        for (int i = 0; i < INT; i++) {
            for (int j = 0; j < 100; j++) {
                mainCancarency.inc();
                System.out.println(threadLocal.get().format(new Date()));
            }
        }
    }

    private void inc() {
        atomicInteger.incrementAndGet();
    }

    //TODO 6 - AtomicInteger

//        final MainCancarency mainCancarency = new MainCancarency();
//         for (int i = 0; i < INT; i++) {
//                for (int j = 0; j < 100; j++) {
//                    mainCancarency.inc();
//                }
//        }
//        System.out.println(mainCancarency.atomicInteger.get());
//    }
//
//    private void inc() {
//        atomicInteger.incrementAndGet();
//    }

    //TODO 5

//        final MainCancarency mainCancarency = new MainCancarency();
//        CountDownLatch latch = new CountDownLatch(INT); // замок
//        ExecutorService executorService = Executors.newCachedThreadPool(); //лімітоване середовище потоків
//        CompletionService completionService = new ExecutorCompletionService(executorService); // можна брати першу виконану таску
//
//        for (int i = 0; i < INT; i++) {
//            Future<Integer> future = executorService.submit(() -> {
//                for (int j = 0; j < 100; j++) {
//                    mainCancarency.inc();
//                }
//                latch.countDown();
//                return 5;
//
//            });
//
//        }
//    }
//
//    private void inc() {
//        try {
//            lock.lock();
//            count++;
//        } finally {
//            lock.unlock();
//        }
//
//
//    }


    //TODO 4

//        final MainCancarency mainCancarency = new MainCancarency();
//        CountDownLatch latch = new CountDownLatch(INT); // замок
//        ExecutorService executorService = Executors.newCachedThreadPool(); //лімітоване середовище потоків
//        CompletionService completionService = new ExecutorCompletionService(executorService); // можна брати першу виконану таску
//
//        for (int i = 0; i < INT; i++) {
//            Future<Integer> future = executorService.submit(() -> {
//                for (int j = 0; j < 100; j++) {
//                    mainCancarency.inc();
//                }
//                latch.countDown();
//                return 5;
//
//            });
//
//        }


    //TODO 3

//        final MainCancarency mainCancarency = new MainCancarency();
//        CountDownLatch latch = new CountDownLatch(INT); // замок
//        ExecutorService executorService = Executors.newCachedThreadPool(); //лімітоване середовище потоків
//
//        for (int i = 0; i < INT; i++) {
//            executorService.submit(() -> {
//                for (int j = 0; j < 100; j++) {
//                    mainCancarency.inc();
//                }
//                latch.countDown(); // відрахунок константи, для синхронизації, як замок
//            });
//        }
//        latch.await(10, TimeUnit.SECONDS);//ліміт часу очікування закінчення всіх робіт потоків
//        executorService.shutdown();
//        System.out.println(count);


    //TODO 2

//        final MainCancarency mainCancarency = new MainCancarency();
//        CountDownLatch latch = new CountDownLatch(INT); // замок
//        for (int i = 0; i < INT; i++) {
//            final Thread thread = new Thread(() -> {
//                for (int j = 0; j < 100; j++) {
//                    mainCancarency.inc();
//                }
//                latch.countDown(); // відрахунок константи, для синхронизації, як замок
//            });
//            thread.start();
//        }
//        latch.await(10, TimeUnit.SECONDS);
//        System.out.println(count);

//TODO 1

//        final MainCancarency mainCancarency = new MainCancarency();
//        List<Thread> threadList = new ArrayList<>(INT);
//        for (int i = 0; i < INT; i++) {
//            final Thread thread = new Thread(() -> {
//                for (int j = 0; j < 100; j++) {
//                    mainCancarency.inc();
//                }
//            });
//            thread.start();
//            threadList.add(thread);
//        }
//        threadList.forEach(thread -> {
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        System.out.println(count);
//}

//    private synchronized void inc() {
////        synchronized (this) {
////        synchronized (MainCancarency.class) {
////        notifyAll();
//        count++;
//    }
////     }
////    }
}

