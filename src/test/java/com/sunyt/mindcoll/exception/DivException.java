package com.sunyt.mindcoll.exception;

public class DivException extends Exception{
    public DivException(String message) {
        super(message);
    }
    public void ExceptionOutput(){
        System.out.println("div exception yet");
    }
}
