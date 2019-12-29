package jvm.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * 引用队列
 */
public class ReferenceQueueDemo {
    public static void main(String[] args) {


//        Object o1 = new Object();
//        ReferenceQueue<Object> queue = new ReferenceQueue();
//        WeakReference wr = new WeakReference(o1,queue);
//
//        System.out.println(o1);
//        System.out.println(wr.get());
//        System.out.println(queue.poll());
//
//        System.out.println("===========================");
//
//        o1 = null;
//        System.gc();
//        try{ TimeUnit.SECONDS.sleep(1); }catch(Exception e){e.printStackTrace();}
//        System.out.println(o1);
//        System.out.println(wr.get());
//        System.out.println(queue.poll());

        photmReferenceTest();
    }


    private static void photmReferenceTest() {
        Object o1 = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue();
        Reference wr = new WeakReference(o1, queue);
        referenceQueueDemo(wr,o1,queue);
    }

    private static void referenceQueueDemo(Reference wr, Object o1, ReferenceQueue queue) {
        System.out.println(o1);
        System.out.println(wr.get());
        System.out.println(queue.poll());

        System.out.println("*******");

        o1 = null;
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(o1);
        System.out.println(wr.get());
        System.out.println(queue.poll());
    }
}
