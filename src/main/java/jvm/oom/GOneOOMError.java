package jvm.oom;

import java.util.ArrayList;
import java.util.List;


/**
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+UseG1GC
 */
public class GOneOOMError {


    public static void main(String[] args) {
        List<String> list = new ArrayList();
        while(true){
            list.add("test string");
        }

    }
}
