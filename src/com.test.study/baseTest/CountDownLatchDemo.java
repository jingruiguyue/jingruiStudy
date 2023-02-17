package com.test.study.baseTest;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"测试");
                System.out.println("变化前"+countDownLatch.getCount());
                countDownLatch.countDown();
                System.out.println("变化后"+countDownLatch.getCount());
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("程序结束");
    }
}
