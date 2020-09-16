package com.province.postdoctor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.province.postdoctor.mapper")
public class PostdoctorApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostdoctorApplication.class, args);
    }
    //git测试

}
