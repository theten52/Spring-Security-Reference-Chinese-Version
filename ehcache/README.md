#Spring Boot集成EHCache实现缓存机制【从零开始学Spring Boot】
http://412887952-qq-com.iteye.com/blog/2294952
-----

注意事项:
    1.添加依赖:

    <!--Parent-->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.4.0.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <dependencies>
        <!--
            包含支持UI模版（Velocity，FreeMarker，JasperReports），
            邮件服务，
            脚本服务(JRuby)，
            缓存Cache（EHCache），
            任务计划Scheduling（uartz）。
         -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context-support</artifactId>
        </dependency>

        <!-- 集成ehcache需要的依赖-->
        <!--ehcache -->
        <dependency>
            <groupId>net.sf.ehcache</groupId>
            <artifactId>ehcache</artifactId>
        </dependency>   
    </dependencies>    
    
2.注意名称EhCache;
3.配置conf/ehcache.xml配置;
4.配置EhCacheConfig类;
5.在service中使用;