package com.wj.spring.controller;

import com.wj.spring.entity.Otm2Role;
import com.wj.spring.entity.Otm2User;
import com.wj.spring.service.Otm2RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @Autowired
    private Otm2RoleService roleService;

    @RequestMapping("/save")
    public Otm2Role save() {
        Otm2User otm2User = new Otm2User();
        otm2User.setName("123456");
        otm2User.setPassword("123456");

        Otm2Role otm2Role = new Otm2Role();
        otm2Role.setRole_name("student");
        otm2Role.setOtm2User(otm2User);

        otm2Role = roleService.saveRole(otm2Role);
        return otm2Role;
    }
}
