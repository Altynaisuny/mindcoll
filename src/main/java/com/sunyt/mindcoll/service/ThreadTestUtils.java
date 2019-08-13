package com.sunyt.mindcoll.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
@PropertySource("classpath:application.yml")
public class ThreadTestUtils {

    @Value("${Thread.corePoolSize}")
    Integer corePoolSize;

    ExecutorService executorService;

    public ExecutorService findThreadSingle(){
        executorService = new ThreadPoolExecutor(corePoolSize, 5, 0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(20),
                new ThreadPoolExecutor.AbortPolicy());
        return executorService;
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }
}
