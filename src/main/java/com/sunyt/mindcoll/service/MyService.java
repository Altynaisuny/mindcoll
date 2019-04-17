package com.sunyt.mindcoll.service;

import com.sunyt.mindcoll.JdbcTemplateCondition;
import org.springframework.context.annotation.Conditional;

@Conditional(JdbcTemplateCondition.class)
public class MyService {
    //条件成立才会创建这个bean
}
