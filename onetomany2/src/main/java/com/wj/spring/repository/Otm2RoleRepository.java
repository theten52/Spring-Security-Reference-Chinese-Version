package com.wj.spring.repository;

import com.wj.spring.entity.Otm2Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Otm2RoleRepository extends JpaRepository<Otm2Role, Long> {
}
