package com.hundsun.operation.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyStack {
    private List list = new ArrayList();

    synchronized public void push(){

    }

    synchronized public String pop(){
        String returnValue = "";
        try{
            if (list.size() == 0){
                System.out.println("pop操作的线程是" + Thread.currentThread().getName() + "线程呈  wait 状态");
                this.wait();
                returnValue = "" +list.get(0);
                list.remove(0);
                this.notify();
                HashMap hashMap = new HashMap();
                System.out.println("pop =" +list.size());
                
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        return returnValue;
    }
}
