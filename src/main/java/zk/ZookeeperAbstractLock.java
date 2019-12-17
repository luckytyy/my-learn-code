package zk;

import org.I0Itec.zkclient.ZkClient;

/**
 * Created by yuanyi on 2019/11/16,0016.
 */
public abstract class ZookeeperAbstractLock implements MyLock {

    private static final String CONNETSTRING = "127.0.0.1:2181";
    protected ZkClient zkClient = new ZkClient(CONNETSTRING);

    protected String path ="/node";
    protected String path2 = "/node2";

    @Override
    public void getLock() {
        if(tryLock()){
            System.out.println("#####获取lock的资源########");
        }else{
            // 等待
            waitLock();

            // 重新获取资源
            getLock();
        }
    }

    abstract boolean tryLock();

    abstract void waitLock();

}
