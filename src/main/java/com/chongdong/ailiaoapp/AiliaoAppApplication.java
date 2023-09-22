package com.chongdong.ailiaoapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.chongdong.ailiaoapp.mapper")
@EnableScheduling
public class AiliaoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiliaoAppApplication.class, args);
    }

}
