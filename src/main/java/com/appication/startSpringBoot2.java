package com.appication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class startSpringBoot2 {
    public static void main(String[] args) {
        SpringApplication.run(startSpringBoot2.class, args);
    }
    @RequestMapping("/")
    public String toIndex(){
        return "index";
    }
}
