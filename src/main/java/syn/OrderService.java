package syn;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yuanyi on 2019/11/16,0016.
 */
public class OrderService {

    private static int number = 0;

    private static Object lock = new Object();

    public static String getNumber(){
//        synchronized (lock) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            String numberStr = sdf.format(new Date()) + " - " + (++number);
            return numberStr;
//        }
    }
}
