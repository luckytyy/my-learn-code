package zk;

import org.I0Itec.zkclient.IZkDataListener;

import java.util.concurrent.CountDownLatch;

/**
 * Created by yuanyi on 2019/11/16,0016.
 * 基于异常的分布式锁实现；
 * 利用 zk的 创建临时不带序号的节点方式；
 */
public class MyZkDistributeLock extends ZookeeperAbstractLock {

    CountDownLatch countDownLatch;
//    @Override
//    public void getLock() {
//        // 创建临时不带序号的节点，如果创建成功，则获取锁；否则 监听那个已有节点 等待
//
//    }

    @Override
    boolean tryLock() {
        try {
            this.zkClient.createEphemeral(path);
            return true;
        }catch (Exception e){
            return false;

        }
    }

    @Override
    void waitLock() {
        if(zkClient.exists(path)){
            countDownLatch = new CountDownLatch(1);
        }
        IZkDataListener dataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                if(countDownLatch != null ){
                    countDownLatch.countDown();
                }
            }
        };
        zkClient.subscribeDataChanges(path,dataListener);

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        zkClient.unsubscribeDataChanges(path,dataListener);
    }

    @Override
    public void unlock() {
        if(this.zkClient != null){
            zkClient.delete(path);
        }
    }
}
