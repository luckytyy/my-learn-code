package lock;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyHoldThread implements Runnable
{

    Lock lockA;
    Lock lockB;

    public MyHoldThread(Lock lockA, Lock lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        lockA.lock();
        System.out.println(Thread.currentThread().getName()+"持有锁"+lockA+"，尝试获取锁"+lockB);
        try{ TimeUnit.SECONDS.sleep(3); }catch(Exception e){e.printStackTrace();}
        lockB.lock();
    }
}

public class DeadLockTest {

    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        new Thread(new MyHoldThread(lock1,lock2),"AAA").start();
        new Thread(new MyHoldThread(lock2,lock1),"BBB").start();

    }
}
