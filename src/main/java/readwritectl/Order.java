package readwritectl;

import java.util.Random;

/**
 * Created by yuanyi on 2019/11/24,0024.
 */
public class Order {

    private static volatile int number = 0;

    public static void sleep(long sleepMillSeconds){
        try {
            Thread.sleep(sleepMillSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread nt1 = new Thread(new ReadThread());
        Thread nt2 = new Thread(new ReadThread());
        Thread nt3 = new Thread(new ReadThread());
        Thread nt4 = new Thread(new ReadThread());
        nt1.start();
        nt2.start();
        nt3.start();
        nt4.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    sleep(400);
                    int offset = new Random().nextInt(100);
                    number = number + offset;
                    System.out.println("main thread write number = "+number);
                }
            }
        }).start();

    }


    static class ReadThread implements Runnable{

        @Override
        public void run() {
            for(int i=0;i<10;i++) {
                sleep(500);
                System.out.println(Thread.currentThread().getName()+" get "+ number);
            }
        }
    }
}
