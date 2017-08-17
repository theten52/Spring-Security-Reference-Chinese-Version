package com.wj.security4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //允许所有用户访问"/"和"/login"
                .antMatchers("/", "/login").permitAll()
                .antMatchers("/js/**", "/css/**", "/img/**", "/images/**", "/fonts/**", "/**/favicon.ico").permitAll()
                //其他地址的访问均需验证权限
                .anyRequest().authenticated()
                .and()
                //指定登录页是"/login",登录成功后默认跳转到"/home",登录失败则进入/login?error
                .formLogin().loginPage("/login").defaultSuccessUrl("/home").failureUrl("/login?error").permitAll() //登录页面用户任意访问
                .and()
                //退出登录后的默认url是"/home"
                .logout().logoutSuccessUrl("/home").permitAll(); //注销行为任意访问
    }
}