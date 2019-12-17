package lock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yuanyi on 2019/11/16,0016.
 */
public class OrderService {

    private static int number = 0;

    static Lock lock = new ReentrantLock();

    public static String getNumber(){
        try {
            lock.lock();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            String numberStr = sdf.format(new Date()) + " - " + (++number);
            return numberStr;
        }finally {
            lock.unlock();
        }
    }
}
