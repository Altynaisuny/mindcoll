package com.sunyt.mindcoll;

public class RunnableTest implements Runnable{
    private int flag = 1;
    //资源1
    private static Object obj1 = new Object();
    //资源2
    private static Object obj2 = new Object();


    @Override
    public void run() {
        System.out.println("flag = " + flag);
        if (flag == 1){
            synchronized (obj1){
                System.out.println("success lock obj1 , ready lock obj2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2){
                    System.out.println("lock obj2 success");
                }
            }
        }

        if (flag == 0){
            synchronized (obj2){
                System.out.println("success lock obj2 , ready lock obj1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (obj1){
                    System.out.println("lock obj1 success");
                }
            }
        }
    }

    public static void main(String[] args) {
        RunnableTest run01 = new RunnableTest();
        RunnableTest run02 = new RunnableTest();

        run01.flag = 1;
        run02.flag = 0;

        Thread thread01 = new Thread(run01);
        Thread thread02 = new Thread(run02);

        System.out.println("线程开始");
        //死锁竞争的是同一个竞争资源
        thread01.start();
        thread02.start();

    }
}
