package com.sunyt.mindcoll.service;

import com.sunyt.mindcoll.annotation.LogAnnotation;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @LogAnnotation("this is user service")
    public static void add(){
        System.out.println("user service add ....");
    }

    public static void main(String[] args) {
        UserService.add();
    }
}
