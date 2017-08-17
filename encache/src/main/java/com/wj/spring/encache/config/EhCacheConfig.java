package com.wj.spring.encache.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * 注册缓存管理对象EhCacheCacheManager、缓存工厂对象EhCacheManagerFactoryBean
 */
@Configuration
@EnableCaching//标注启动缓存.
public class EhCacheConfig {

    /**
     * ehcache 主要的管理器
     */
    @Bean
    public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean) {
        System.out.println("CacheConfiguration.ehCacheCacheManager()");
        return new EhCacheCacheManager(bean.getObject());
    }

    /**
     * 据shared与否的设置,
     * Spring分别通过CacheManager.create()
     * 或new CacheManager()方式来创建一个ehcache基地.
     * <p>
     * 也说是说通过这个来设置cache的基地是这里的Spring独用,还是跟别的(如hibernate的Ehcache共享)
     */
    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
        System.out.println("CacheConfiguration.ehCacheManagerFactoryBean() create success!");
        EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("conf/ehcache.xml"));
        cacheManagerFactoryBean.setShared(true);
        return cacheManagerFactoryBean;
    }
}
