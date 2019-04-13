package com.sunyt.mindcoll.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i =0 ;i<20;i++){
            executorService.execute(new TestRunnable());
            System.out.println("**************  a" + i + "*********");
        }
        executorService.shutdown();

    }
}
