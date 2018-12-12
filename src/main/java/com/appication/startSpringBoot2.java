package com.appication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
@EnableScheduling
public class startSpringBoot2 {
    public static void main(String[] args) {
        SpringApplication.run(startSpringBoot2.class, args);
    }
    @RequestMapping("/123")
    public String toIndex(){
        return "index";
    }
}
