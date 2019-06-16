package io.github.cd871127.conceal.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadService {

    public void go() {
        threadPoolExecutor();
    }


    private void threadPoolExecutor() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<Runnable> runnables = new ArrayList<>();
        try {
        Task task=new Task();
        for (int i = 0; i < 10; ++i) {
            executorService.submit(task);
        }

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println("shutdown");
    }
}

class Task implements Runnable {

    static private ThreadLocalCD threadLocalTestThreadLocal=new ThreadLocalCD();

    @Override
    public void run() {
        threadLocalTestThreadLocal.get().print();
    }
}

class ThreadLocalCD extends ThreadLocal<ThreadLocalTest>{
    @Override
    protected ThreadLocalTest initialValue() {
        return new ThreadLocalTest();
    }
}

class ThreadLocalTest {

    private volatile int count=0;
    long time;

    public ThreadLocalTest() {
        time=System.currentTimeMillis();
    }

    public void print(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread: "+Thread.currentThread().getId()+"  time: "+this);
    }
}