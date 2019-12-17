package distributeCall;

/**
 * Created by yuanyi on 2019/11/17,0017.
 */
public class UserService {

    public String getUserInfo(long userId){
        long t1 = System.currentTimeMillis();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("查询用户个人信息完毕，耗时为："+(System.currentTimeMillis() - t1));
        return "{'id':"+userId+",'userName':'honghao'}";
    }


}
