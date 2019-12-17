package proxy.jdk;

import proxy.User;

/**
 * Created by yuanyi on 2019/11/24,0024.
 */
public class UserServiceImpl implements IUserService{


    @Override
    public final  void addUser(User user) {
        System.out.println("add user success...");
    }
}
