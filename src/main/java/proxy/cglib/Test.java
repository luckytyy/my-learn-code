package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import proxy.User;
import proxy.jdk.UserServiceImpl;

/**
 * Created by yuanyi on 2019/11/24,0024.
 */
public class Test {

    public static void main(String[] args) {
        Enhancer enhancer =  new Enhancer();
        enhancer.setSuperclass(MyUserServiceImpl.class);
        enhancer.setCallback(new UserServiceInterceptor());
        MyUserServiceImpl service = (MyUserServiceImpl)enhancer.create();
        service.addUser(new User());

    }
}
