package com.example.study01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

// 서블릿 자동등록
@ServletComponentScan
@SpringBootApplication
public class Study01Application {

    public static void main(String[] args) {
        SpringApplication.run(Study01Application.class, args);
    }

}
