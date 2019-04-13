package com.sunyt.mindcoll.service;

import java.util.HashSet;
import java.util.Hashtable;

public class ReflectTest {

    public static void main(String[] args) {
        Class<?> person1 = null;
        try {
            person1 = Class.forName("com.sunyt.mindcoll.service.ReflectTest");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(person1.getName());
        Class<?> demo = new Demo().getClass();
        System.out.println(demo.getName());
        //2种方式

        Class<?> demoTest = null;
        try {
            demoTest = Class.forName("com.sunyt.mindcoll.service.Demo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Demo demo1 =null;
        try {
            demo1 = (Demo) demoTest.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        demo1.setPage("1234");
        System.out.println(demo1.getPage());
    }
}

class Demo{
    private String username;
    private String page;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
