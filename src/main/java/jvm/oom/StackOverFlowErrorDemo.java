package jvm.oom;

public class StackOverFlowErrorDemo {

    public static void main(String[] args) {

        stackOverFlowTest();
    }

    private static void stackOverFlowTest() {
        stackOverFlowTest();
    }
}
