package com.sunyt.mindcoll.Similar;

import com.sunyt.mindcoll.Name;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimTest {
    public static void main(String[] args) {
        Name name = new Name();
        Name nameSec = new Name();

        HashSet hashSet = new HashSet();
        Map map = new HashMap();
        System.out.println(name.equals(nameSec));
        System.out.println(name.hashCode());
        System.out.println(nameSec.hashCode());

        ExecutorService executorService = Executors.newFixedThreadPool(50);

        executorService.shutdown();
    }
}
