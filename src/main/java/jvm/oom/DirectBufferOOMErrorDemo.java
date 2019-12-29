package jvm.oom;


import java.nio.ByteBuffer;

/**
 *     -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 */
public class DirectBufferOOMErrorDemo {
    public static void main(String[] args) {
        ByteBuffer.allocateDirect(6*1024*1024);
    }
}
