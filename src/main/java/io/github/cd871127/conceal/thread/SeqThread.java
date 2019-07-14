package io.github.cd871127.conceal.thread;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程依次输出
 *
 * @author anthony
 */

public class SeqThread {


    public SeqThread() {
    }

    public static void main(String[] args)  {
        ThreadFactory threadFactory = Thread::new;
        ExecutorService service = new ThreadPoolExecutor(3, 3, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), threadFactory);
        service.submit(new ThreadTest("A"));
        service.submit(new ThreadTest("B"));
        service.submit(new ThreadTest("C"));


        service.shutdown();
    }
}

class ThreadTest implements Runnable {

    private final String res;

    private static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

    private static Lock lock = new ReentrantLock();

    static {
        queue.add("A");
        queue.add("B");
        queue.add("C");
    }

    ThreadTest(String res) {
        this.res = res;
    }


    @Override
    public void run() {
        int count = 0;
        while (count < 10) {
            lock.lock();
            if (res.equals(queue.peek())) {
                try {
                    queue.take();
                    queue.put(res);
                    System.out.println(res);
                    ++count;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            lock.unlock();
        }
    }
}
