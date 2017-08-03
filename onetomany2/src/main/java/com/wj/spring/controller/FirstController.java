package com.wj.spring.controller;

import com.wj.spring.entity.Role;
import com.wj.spring.entity.User;
import com.wj.spring.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/save")
    public Role save() {
        User user = new User();
        user.setName("123456");
        user.setPassword("123456");

        Role role = new Role();
        role.setRole_name("student");
        role.setUser(user);

        role = roleService.saveRole(role);
        return role;
    }
}
