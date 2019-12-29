package jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 *   -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 *   从实际运行情况来看，偶尔会出现 Gc overhead execeeded limit; 较多出现的是 max heap size;!!
 *
 *
 *   当jvm参数设置为
 *   -Xms20m -Xmx20m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 *   的时候，每次都能复现 出  GC overhead limit exceeded
 *   说明堆内存要设置的足够大，堆外内存设置的小一点，这样还是能够GC，一直full GC到一定程度之后，才会出现这个问题！！！
 *
 *
 *   元空间区域也是 在堆外内存 Direct Memory
 */
public class GCOverheadExeceedDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList();
        int i=0;
        try {
            while (true) {
                list.add(String.valueOf(i++).intern());
            }
        }catch (Throwable e){
            System.out.println("size = "+list.size());
            throw e;
        }
    }
}
