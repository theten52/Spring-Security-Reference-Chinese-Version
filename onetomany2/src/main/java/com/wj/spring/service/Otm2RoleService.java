package com.wj.spring.service;

import com.wj.spring.entity.Otm2Role;
import com.wj.spring.repository.Otm2RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Otm2RoleService {
    @Autowired
    private Otm2RoleRepository otm2RoleRepository;

    public Otm2Role saveRole(Otm2Role otm2Role) {
        return otm2RoleRepository.save(otm2Role);
    }
}
