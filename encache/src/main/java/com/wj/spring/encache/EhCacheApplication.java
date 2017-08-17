package com.wj.spring.encache;

import com.wj.spring.encache.controller.DemoInfoController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EhCacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(EhCacheApplication.class, args);
        DemoInfoController demoInfoController = new DemoInfoController();
        demoInfoController.test();
    }
}
