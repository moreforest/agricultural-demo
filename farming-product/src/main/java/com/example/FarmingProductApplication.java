package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: Cao
 * @Description: 命令启动   mvn spring-boot:run
 * @Date: 2020/9/7
 **/
@SpringBootApplication
//@MapperScan("com.example.mapper")
public class FarmingProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(FarmingProductApplication.class, args);
    }
}
