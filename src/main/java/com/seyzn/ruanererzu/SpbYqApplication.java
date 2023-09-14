package com.seyzn.ruanererzu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.seyzn.ruanererzu.mapper")
public class SpbYqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpbYqApplication.class, args);
    }

}
