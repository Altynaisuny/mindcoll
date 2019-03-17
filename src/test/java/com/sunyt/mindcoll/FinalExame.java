package com.hundsun.operation.manager;

public class FinalExame {
    public static void main(String[] args) {
        Name name = new Name();
        try {
            if (name.getId() == null){
                throw new IllegalArgumentException("参数不规范");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
class nebord{
}
