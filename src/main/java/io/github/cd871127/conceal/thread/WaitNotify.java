package io.github.cd871127.conceal.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaitNotify implements Runnable {
    @Override
    public void run() {

    }

    public static void main(String[] args) {
        Lock lock=new ReentrantLock();
        Condition condition1=lock.newCondition();
        Condition condition2=lock.newCondition();
        System.out.println(condition1==condition2);
    }
}
