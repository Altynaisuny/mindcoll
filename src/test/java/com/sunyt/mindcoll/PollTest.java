package com.sunyt.mindcoll;

import java.util.concurrent.*;

public class PollTest {
    public static void main(String[] args) {
        //coolPoolSize/maximumPoolSize/keepAliveTime/TimeUnit
        //核心线程数的最大值，新建线程，如果大于coolPoolSize，新建非核心线程。如果 小于 coolPoolSize，新建核心线程。
        int corePoolSize = 50;
        //最大线程数
        //线程数 = 线程数+非核心线程数
        int maximumPoolSize = 100;
        //线程超时时间
        long keepAliveTime = 2000;
        //timeUnit
        //可缓冲线程池 CacheThreadPool()
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        //定长线程池 可控制线程最大并发数  超出的线程会在队列中等待
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(50);
        //定时线程池，支持定时及周期性的任务
        ExecutorService executorService = Executors.newScheduledThreadPool(50);
        //单线程化的线程池
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
//        ThreadPoolExecutor
    }
}
