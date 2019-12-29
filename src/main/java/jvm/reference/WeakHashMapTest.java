package jvm.reference;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapTest {


    public static void main(String[] args) {
        myHashMap();
        System.out.println("========================");
        myWeakHashMap();
    }

    private static void myWeakHashMap() {

        Map<Integer, String> map = new WeakHashMap<>();
        Integer key = new Integer(1);  // Integer key = 1;
        String val = "WeakHashMap";
        map.put(key, val);
        // 像下面这种put方式，如果发生gc，会无法找到 new Integer(2)的引用，那么会把它回收！！！
        map.put(new Integer(2),"test2");
        Integer key3 = new Integer(3);
        map.put(key3,"test3");

        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map);
    }

    private static void myHashMap() {
        Map<Integer, String> map = new HashMap();
        Integer key = 1;
        String val = "test1";
        map.put(key, val);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map);

    }
}
