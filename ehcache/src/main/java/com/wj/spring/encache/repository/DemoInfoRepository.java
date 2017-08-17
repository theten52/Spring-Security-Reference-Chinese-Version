package com.wj.spring.encache.repository;

import com.wj.spring.encache.entity.DemoInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoInfoRepository extends CrudRepository<DemoInfo,Long>{

}