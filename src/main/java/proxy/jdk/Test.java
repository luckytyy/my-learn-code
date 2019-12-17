package proxy.jdk;

import proxy.User;

import java.lang.reflect.Proxy;

/**
 * Created by yuanyi on 2019/11/24,0024.
 */
public class Test {

    public static void main(String[] args) {

        IUserService tmp = new UserServiceImpl();
        IUserService service = (IUserService)Proxy.newProxyInstance(Test.class.getClassLoader(), tmp.getClass().getInterfaces(),
                new UserInvocationHandler(tmp));
        service.addUser(new User());
    }
}
