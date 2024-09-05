package src.com.test.study.threaddemo;

import java.sql.SQLOutput;

/********************************************************
 * @ClassName:
 * @Description:
 *
 * @Date: 2024/7/11
 * @Author: xujingrui
 * @Version:1.0
 ********************************************************/
public class ShouHuThread {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
         while(true){
             try {
                 Thread.sleep(1000);
                 System.out.println("我是子线程即用户线程，I am running");
             }catch (Exception e){
                 System.out.println("子线程异常");
             }
         }
        });
        //t1.setDaemon(true);
        t1.start();
        Thread.sleep(3000L);
        System.out.println("主线程执行完毕");
    }
}
