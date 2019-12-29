package jvm.gc;

import java.util.concurrent.TimeUnit;

public class HelloGC {

    public static void main(String[] args) {
        System.out.println("Hello gc start");
        try{ TimeUnit.SECONDS.sleep(Long.MAX_VALUE); }catch(Exception e){e.printStackTrace();}
    }
}
