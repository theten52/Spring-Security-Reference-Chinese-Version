package com.wj.springsecurity.service;

import com.wj.springsecurity.entity.UserInfo;
import com.wj.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SUserService {
    @Autowired
    private UserRepository userRepository;

    public UserInfo findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
