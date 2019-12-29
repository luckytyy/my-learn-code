package jvm.reference;

import java.lang.ref.SoftReference;

/**
 * 强引用
 */
public class ReferenceTest {
    public static void main(String[] args) {

        Object b1 = new Object();
        Object b2 = b1;
        b1 = null;
        System.gc();
        System.out.println(b2);


    }
}
