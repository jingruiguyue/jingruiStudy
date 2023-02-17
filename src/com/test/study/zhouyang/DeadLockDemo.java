package com.test.study.zhouyang;

import java.util.concurrent.TimeUnit;

class LockDemo implements Runnable {
    String lockA = null;
    String lockB = null;

    public LockDemo(String locka,String lockb){
        this.lockA = locka;
        this.lockB = lockb;
    }

    @Override
    public void run() {
        synchronized(this.lockA){
            System.out.println(Thread.currentThread().getName()+"线程A等待获取线程B"+this.lockB);

            try{
                TimeUnit.SECONDS.sleep(2L);
            }catch(Exception e){
                System.out.println("测试死锁类异常");
            }
            synchronized(this.lockB){
                System.out.println(Thread.currentThread().getName()+"线程A等待获取线程B"+this.lockA);
            }
        }
    }
}

public class DeadLockDemo {
    public static void main(String[] args) {
        String aaa = "AAA";
        String bbb = "BBB";
        Thread threada = new Thread(new LockDemo(aaa,bbb));
        threada.start();
        Thread threadb = new Thread(new LockDemo(bbb,aaa));
        threadb.start();
    }
}
