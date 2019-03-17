package com.sunyt.mindcoll;

public class NormalMethods {

    synchronized void getMethods(){

    }

    void methodsToNormal(){
        synchronized (this){
            System.out.println("synchronized");
        }
    }

    static synchronized void methodsTranslate(){

    }

    static void methods(){
        synchronized (NormalMethods.class){
            System.out.println("synchronized methods class");
        }
    }

    private void resecure(){
        ThreadTest threadTest = new ThreadTest();
        threadTest.run();
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NormalMethods normalMethods = new NormalMethods();
        normalMethods.resecure();
        System.out.println("main thread --");
    }
}
