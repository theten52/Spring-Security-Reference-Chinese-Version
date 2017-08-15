package com.wj.springsecurity2.repository;

import com.wj.springsecurity2.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<SysUser,Long> {
    SysUser findSysUserByUsername(String username);
}
