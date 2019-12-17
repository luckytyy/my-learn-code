package zk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

class OrderThread extends Thread {

    private static final int number = 100;
    static CountDownLatch countDownLatch =  new CountDownLatch(number);
    private static List<Integer> dataList =new ArrayList();

    @Override
    public void run() {
        try {
            String number = OrderService.getNumber();
            dataList.add(Integer.parseInt(number));
            countDownLatch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        for(int i=0;i<number;i++){
            new OrderThread().start();
        }
        try {
            countDownLatch.await();
            Collections.sort(dataList);
            System.out.println(dataList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}