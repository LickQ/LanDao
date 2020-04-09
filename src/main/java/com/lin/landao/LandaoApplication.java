package com.lin.landao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lin.landao.dao")

public class LandaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LandaoApplication.class, args);
    }

}
