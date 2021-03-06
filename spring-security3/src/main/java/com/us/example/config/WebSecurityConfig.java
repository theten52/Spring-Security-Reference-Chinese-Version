package com.us.example.config;

import com.us.example.repository.UserRepository;
import com.us.example.service.CustomUserService;
import com.us.example.service.MyFilterSecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserRepository userRepository;
    private final MyFilterSecurityInterceptor myFilterSecurityInterceptor;

    @Autowired
    public WebSecurityConfig(UserRepository userRepository, MyFilterSecurityInterceptor myFilterSecurityInterceptor) {
        this.userRepository = userRepository;
        this.myFilterSecurityInterceptor = myFilterSecurityInterceptor;
    }


    @Bean
    UserDetailsService customUserService() { //注册UserDetailsService 的bean
        return new CustomUserService(userRepository);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService()); //user Details Service验证
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated() //任何请求,登录后可以访问
                .antMatchers("/js/**", "/css/**", "/img/**", "/images/**", "/fonts/**", "/**/favicon.ico").permitAll()
                .and()
                .formLogin().loginPage("/login").failureUrl("/login?error").permitAll() //登录页面用户任意访问
                .and()
                .logout().permitAll(); //注销行为任意访问

        //关闭csrf;
        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class)
                .csrf().disable();
    }
}

