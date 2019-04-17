package com.sunyt.mindcoll.exception;

public class mainTest {
    public static void main(String[] args) throws Exception {
        ExceptionTest exceptionTest = new ExceptionTest();
        try {
            exceptionTest.execute();
        }catch (Exception e ){
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("777");
        } catch (Throwable throwable) {
            throw new Exception("6666");
        }
        System.out.println("4444");
    }
}
