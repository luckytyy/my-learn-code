package jvm.reference;

import java.lang.ref.SoftReference;

public class SoftReferenceTest {


    public static void softReferenceEnough() {
        Object o1 = new Object();
        SoftReference<Object> s1 = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(s1.get());
        System.gc();
        System.out.println(o1);
        System.out.println(s1.get());

    }

    /**
     * -Xms5m -Xmx5m  -XX:+PrintGCDetails
     * 故意设置小的内存，看回收的情况
     */
    public static void softReferenceNotEnough() {
        Object o1 = new Object();
        SoftReference<Object> s1 = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(s1.get());
        o1 = null;
        try {
            byte[] res = new byte[30 * 1024 * 1024];
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(o1);
            System.out.println(s1.get());
        }
    }


    public static void main(String[] args) {
//        softReferenceEnough();

        softReferenceNotEnough();
    }
}
