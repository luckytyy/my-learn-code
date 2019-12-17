package distributeCall;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by yuanyi on 2019/11/17,0017.
 */
public class SerializeCallService {

    public static String getUserTotalInfo(long userId){
        UserService userService = new UserService();
        MoneyService moneyService = new MoneyService();
        String s1 = userService.getUserInfo(userId);
        String s2 = moneyService.getUserMoneyInfo(userId);
        JSONObject result = new JSONObject();
        JSONObject jsonObject = JSONObject.parseObject(s1);
        JSONObject jsonObject2 = JSONObject.parseObject(s2);
        result.putAll(jsonObject);
        result.putAll(jsonObject2);
        System.out.println("查询结果为："+result);
        return result.toString();
    }

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        long userId = 1L;
        getUserTotalInfo(userId);
        System.out.println("总的耗时为："+(System.currentTimeMillis() - t1));

    }

}
