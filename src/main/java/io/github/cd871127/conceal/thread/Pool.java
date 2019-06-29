package io.github.cd871127.conceal.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Pool {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 1000, TimeUnit.HOURS, new LinkedBlockingQueue<>());
        TestPool testPool = new TestPool();
        for (int i = 0; i != 1000; ++i) {
            threadPoolExecutor.execute(testPool);

        }
        threadPoolExecutor.shutdown();
    }
}

class TestPool implements Runnable {

    private long i;

    @Override
    public void run() {
        ++i;
        --i;
        System.out.println(i);
    }

}