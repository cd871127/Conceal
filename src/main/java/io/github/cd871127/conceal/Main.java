package io.github.cd871127.conceal;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        Executor executor = new ThreadPoolExecutor(3, 3,30, TimeUnit.SECONDS,  new ArrayBlockingQueue<>(3),
                (ThreadFactory) Thread::new);
        executor.execute(() -> {
            int i=0;
            while(true){
                ++i;
            }
        });
    }





}
