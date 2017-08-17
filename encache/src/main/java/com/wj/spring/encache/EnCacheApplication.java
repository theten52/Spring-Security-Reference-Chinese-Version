package com.wj.spring.encache;

import com.wj.spring.encache.controller.DemoInfoController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnCacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(EnCacheApplication.class, args);
        DemoInfoController demoInfoController = new DemoInfoController();
        demoInfoController.test();
    }
}
