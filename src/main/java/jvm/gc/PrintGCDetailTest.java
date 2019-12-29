package jvm.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * jvm  params
 * -XX:+PrintGCDetails -Xms128M -Xmx128M -XX:SurvivorRatio=8 -XX:NewRatio=4
 */
public class PrintGCDetailTest {

    public static void main(String[] args) {
        List<byte[]> list = new ArrayList();
        while(true){
            byte [] b = new byte[10240000];
            list.add(b);
        }
    }
}
