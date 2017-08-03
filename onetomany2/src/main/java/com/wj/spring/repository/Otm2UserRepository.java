package com.wj.spring.repository;

import com.wj.spring.entity.Otm2User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Otm2UserRepository extends JpaRepository<Otm2User,Long>{
}
