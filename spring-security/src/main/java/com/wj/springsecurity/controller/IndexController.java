package com.wj.springsecurity.controller;

import com.wj.springsecurity.service.SUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Controller
public class IndexController {
    //TODO 跑的通吗?

    @Resource
    private SUserService sUserService;

    @RequestMapping("/home")
    public String home() {
        return "home";
    }


    @PreAuthorize("hasRole('user')")
    // @RequestMapping(value = "/admin",method = RequestMethod.POST)
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String toAdmin() {
        return "helloAdmin";
    }

    @RequestMapping("/hello")
    public String hello() {

        return "hello";

    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/")
    public String root() {
        return "index";

    }

    @RequestMapping("/403")
    public String error() {
        return "403";
    }
}