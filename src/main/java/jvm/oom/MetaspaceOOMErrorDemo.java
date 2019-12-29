package jvm.oom;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 元空间 中类信息文件足够多，可以发生这个异常
 * <p>
 * 元空间在 堆外内存
 * <p>
 * -XX:+PrintGCDetails -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m
 */
public class MetaspaceOOMErrorDemo {

    public static void main(String[] args) {
        int i = 0;
        try {
            while (true) {
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o,objects);
                    }
                });
                enhancer.create();
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }finally {
            System.out.println("=====发生Error=== "+i);
        }

    }

    static class OOMTest{};
}
