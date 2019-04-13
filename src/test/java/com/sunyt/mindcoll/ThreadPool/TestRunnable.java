package com.sunyt.mindcoll.ThreadPool;

public class TestRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程被调用了");
    }
}
