package com.wj.spring.encache.Service;

import com.wj.spring.encache.entity.DemoInfo;
import com.wj.spring.encache.exception.NotFoundException;

public interface DemoInfoService {

    void delete(Long id);

    DemoInfo update(DemoInfo updated) throws NotFoundException;

    DemoInfo findById(Long id);

    DemoInfo save(DemoInfo demoInfo);
}
