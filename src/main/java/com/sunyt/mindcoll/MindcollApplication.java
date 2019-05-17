package com.sunyt.mindcoll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;

@SpringBootApplication
public class MindcollApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(MindcollApplication.class, args);
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println("当前默认使用的数据源:" + dataSource.getClass().getName());
        //Error creating bean with name 'dataSource'
    }

}
