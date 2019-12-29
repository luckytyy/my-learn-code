package jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * 每个进程允许创建的最大线程数 由操作系统配置决定，跟jvm配置无关
 *
 * ！！！ 慎重在本机执行；直接导致我的mac 机器重启了！
 */
public class CanNotCreateNativeThreadOOMErrorDemo {
    public static void main(String[] args) {
        int i=0;
        try {
            while (true) {
                Thread t = new Thread(new MyThread());
                t.start();
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("======= i="+i);
        }

    }

    static class MyThread implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
