package jvm.reference;

import java.lang.ref.WeakReference;

public class WearReferenceTest {

    public static void main(String[] args) {

        Object o1 = new Object();
        WeakReference wr = new WeakReference(o1);
        System.out.println(o1);
        System.out.println(wr.get());

        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(wr.get());
    }
}
