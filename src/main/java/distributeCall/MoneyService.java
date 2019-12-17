package distributeCall;

/**
 * Created by yuanyi on 2019/11/17,0017.
 */
public class MoneyService {

    public String getUserMoneyInfo(long userId){
        long t1 = System.currentTimeMillis();
        try {
            Thread.sleep(3600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("查询用户账户信息完毕，耗时为："+(System.currentTimeMillis() - t1));
        return "{'id':"+userId+",'moeny':'1000'}";
    }


}
