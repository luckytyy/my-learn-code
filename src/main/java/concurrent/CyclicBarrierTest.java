package concurrent;


import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest {

    static CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
        @Override
        public void run() {
            System.out.println("大家都到齐了，都继续下一步吧");
        }
    });

    public static void main(String[] args) {

        for(int i=0;i<3;i++){
            new Thread(new MyThread()).start();
        }
    }


    static class MyThread implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"启动");
            try {
                Random rand = new Random();
                int randomRs = rand.nextInt(10);
                System.out.println(Thread.currentThread().getName()+"休眠"+randomRs+"秒");
                TimeUnit.SECONDS.sleep(randomRs);

                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"结束");

        }
    }
}
