package com.us.example.repository;

import com.us.example.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<SysUser,Integer>{
     SysUser findFirstByUsername(String username);
}
