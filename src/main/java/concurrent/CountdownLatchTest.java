package concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by yuanyi on 2019/11/16,0016.
 */
public class CountdownLatchTest {

    // 倒计时器；
    static CountDownLatch countDownLatch = new CountDownLatch(10);


    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            new Thread(new MyThread()).start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }
    }

    static class MyThread implements Runnable{

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println("我是线程"+threadName+"开始等待");
            try {
                countDownLatch.await();
                System.out.println("我是线程"+threadName+"，我处理完毕！");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
