package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by yuanyi on 2019/11/24,0024.
 */
public class UserInvocationHandler implements InvocationHandler {

    IUserService userService;

    public UserInvocationHandler(IUserService userService){
        this.userService = userService;
    }

    public void doBefore(){
        System.out.println("=================doBefore================");
    }


    public void doAfter(){
        System.out.println("=================doAfter================");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        Object invokeResult = method.invoke(userService, args);
        doAfter();
        return invokeResult;
    }
}
