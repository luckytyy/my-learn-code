package lock;

/**
 * Created by yuanyi on 2019/11/16,0016.
 */
public class OrderThread extends Thread {


    @Override
    public void run() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String number = OrderService.getNumber();
        System.out.println(Thread.currentThread().getName()+" get "+ number);

    }


}
