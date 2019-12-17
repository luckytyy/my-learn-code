package syn;

/**
 * Created by yuanyi on 2019/11/16,0016.
 */
public class Test {

    public static void main(String args[]){
        for(int i=0;i<50;i++){
            new OrderThread().start();
        }
    }
}
