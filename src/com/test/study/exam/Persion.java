package com.test.study.exam;

/**
 * 双检锁单例模式
 */
public class Persion {

    private static volatile Persion persion;
    
    private Persion(){}

    public static Persion getInstance(){
        if(persion == null){
            synchronized (com.test.study.exam.Persion.class){
                if(persion == null){
                    persion = new Persion();
                }
            }
        }
        return persion;
    }
}
