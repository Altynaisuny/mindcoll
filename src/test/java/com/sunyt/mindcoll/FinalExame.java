package com.sunyt.mindcoll;

import com.sunyt.mindcoll.exception.DivException;

import java.util.ArrayList;
import java.util.List;

public class FinalExame {
    public static void main(String[] args) {
        Internal internal = new Internal();
        try {
            internal.InternalExceptionTest();
        } catch (Exception e ){
            e.printStackTrace();
        } finally {
            //无论会不会异常，都会执行。
            System.out.println("neorval");
        }
        System.out.println("trouble is not stop");

    }
}
class Internal{

    void InternalExceptionTest(){
        Name name = new Name();
        System.out.println(name.toString());
        List<String> list = new ArrayList<>();
        if (name.getId() == null){
            throw new IllegalArgumentException("参数不规范");
        }
    }

}
