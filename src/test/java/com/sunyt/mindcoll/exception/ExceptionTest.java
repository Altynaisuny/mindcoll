package com.sunyt.mindcoll.exception;

import java.util.ArrayList;
import java.util.List;

public class ExceptionTest {
    public void execute() throws Throwable {
        List list = new ArrayList();
        //list.get(0);
        throw new RuntimeException("11");
    }
}
