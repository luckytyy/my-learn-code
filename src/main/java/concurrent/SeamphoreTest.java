package concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by yuanyi on 2019/11/16,0016.
 */
public class SeamphoreTest {

    // Seamphore 信号量； 用来限流；多个线程竞争资源的时候，每次允许指定个数的线程获取资源
    static Semaphore samphore = new Semaphore(3);

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            new MyThread("线程"+i).start();
        }
    }

    static class MyThread extends Thread{

        private final String threadName;

        MyThread(String threadName){
            this.threadName = threadName;
        }


        @Override
        public void run() {
            try {
                System.out.println(threadName+"准备获取锁");
                samphore.acquire();
                System.out.println(threadName+"获得了锁，开始执行逻辑");
                TimeUnit.MILLISECONDS.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println(threadName+"执行逻辑完毕，准备释放锁");
                samphore.release();
                System.out.println(threadName+"执行逻辑完毕，释放完毕");

            }

        }
    }

}
