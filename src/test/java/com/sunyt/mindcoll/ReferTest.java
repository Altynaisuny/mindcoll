package com.sunyt.mindcoll;

public class ReferTest {

    public static void main(String[] args) {
        InferClassT classT = new InferClassT();
        System.out.println(classT.getClass());
        Class<?> clearCl = null;
        try {
            clearCl = Class.forName("com.sunyt.mindcoll.ReferTest");
            System.out.println(clearCl.getName());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

class InferClassT{

}
