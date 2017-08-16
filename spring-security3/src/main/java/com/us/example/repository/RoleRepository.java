package com.us.example.repository;

import com.us.example.domain.SysRole;
import com.us.example.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RoleRepository extends JpaRepository<SysRole,Integer>{
}
