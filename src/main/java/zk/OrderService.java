package zk;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yuanyi on 2019/11/16,0016.
 */
public class OrderService {

    private static int number = 0;

    private static MyZkDistributeLock myZkDistributeLock = new MyZkDistributeLock();

    public static String getNumber(){
        String numberStr = null;
        try {
            myZkDistributeLock.tryLock();
            int now = number +1;
            number = now;
            numberStr =  ""+(now);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            myZkDistributeLock.unlock();
        }
        return numberStr;
    }
}
