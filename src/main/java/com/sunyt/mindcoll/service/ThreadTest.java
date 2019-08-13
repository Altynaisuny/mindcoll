package com.sunyt.mindcoll.service;

import io.netty.util.concurrent.SingleThreadEventExecutor;
import org.springframework.stereotype.Controller;

import java.util.concurrent.*;

public class ThreadTest implements Runnable{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public ThreadTest(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"      "+name);
        //service
    }
}

