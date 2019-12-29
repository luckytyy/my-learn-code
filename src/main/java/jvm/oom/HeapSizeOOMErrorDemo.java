package jvm.oom;

/**
 * 通过设置小的内存大小 ，更快看到效果
 *
 * -Xms5m -Xmx5m -XX:+PrintGCDetails
 */
public class HeapSizeOOMErrorDemo {

    public static void main(String[] args) {

        byte[]a = new byte[10*1024*1024];

    }
}
