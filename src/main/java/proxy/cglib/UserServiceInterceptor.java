package proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by yuanyi on 2019/11/24,0024.
 */
public class UserServiceInterceptor implements MethodInterceptor {

    public void doBefore(){
        System.out.println("=================cglib doBefore================");
    }


    public void doAfter(){
        System.out.println("=================cglib doAfter================");
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        doBefore();
        Object o1 = methodProxy.invokeSuper(o, objects);
        doAfter();
        return o1;
    }
}
