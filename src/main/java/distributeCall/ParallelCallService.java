package distributeCall;

import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.*;

/**
 * Created by yuanyi on 2019/11/17,0017.
 */
public class ParallelCallService {

    static UserService userService = new UserService();
    static MoneyService moneyService = new MoneyService();

    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 10, 1, TimeUnit.SECONDS,
            new LinkedBlockingDeque<Runnable>(10), new MyThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

    public static String getUserTotalInfo(final long userId) {
        Callable<String> result1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return userService.getUserInfo(userId);
            }
        };
        Callable<String> result2 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return moneyService.getUserMoneyInfo(userId);
            }
        };

        FutureTask<String> task1 = new FutureTask<String>(result1);
        FutureTask<String> task2= new FutureTask<String>(result2);

        threadPoolExecutor.submit(task1);
        threadPoolExecutor.submit(task2);
        JSONObject result = new JSONObject();

        try {
            String s1 = task1.get();
            String s2 = task2.get();

            JSONObject jsonObject = JSONObject.parseObject(s1);
            JSONObject jsonObject2 = JSONObject.parseObject(s2);
            result.putAll(jsonObject);
            result.putAll(jsonObject2);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }


    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        long userId = 1L;
        getUserTotalInfo(userId);
        System.out.println("总的耗时为：" + (System.currentTimeMillis() - t1));
    }

}
