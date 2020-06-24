package com.csteach.teachproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.csteach.teachproject.mapper")
@EnableTransactionManagement(proxyTargetClass = true)
public class TeachprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeachprojectApplication.class, args);
    }

}
