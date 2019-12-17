package distributeCall;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yuanyi on 2019/11/17,0017.
 */
public class MyThreadFactory implements ThreadFactory {

    private volatile AtomicInteger index = new AtomicInteger(0);

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r,"用户线程"+index.addAndGet(1));
    }
}
