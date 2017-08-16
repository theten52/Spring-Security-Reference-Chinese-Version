package com.wj.springsecurity2.config;

import com.wj.springsecurity2.repository.UserRepository;
import com.wj.springsecurity2.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserRepository userRepository;

    @Autowired
    public WebSecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
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
                .anyRequest().authenticated() //任何请求,登录后可以访问,对任何尚未匹配的URL进行身份验证
                //忽略一些资源的访问权限:如静态资源
                .antMatchers(new String[]{"/js/**", "/css/**", "/img/**", "/images/**", "/fonts/**", "/**/favicon.ico"}).permitAll()
                .and()
                // 登录地址，成功跳转地址，登录失败地址
                // .formLogin().loginPage("/login").defaultSuccessUrl("/", true).failureUrl("/login?error")
                .formLogin().loginPage("/login").failureUrl("/login?error")
                .permitAll() //"登录页面"未登录用户也可以访问
                .and()
                .logout().permitAll();  //注销行为任意访问
        // http
        //         .addFilterAfter(getMyFilterSecurityInterceptor(), FilterSecurityInterceptor.class);
    }

    // @Override
    // public void configure(WebSecurity web) throws Exception {
    //忽略一些资源的访问权限:如静态资源
    // web.ignoring().antMatchers("/js/**", "/css/**", "/img/**", "/images/**", "/fonts/**", "/**/favicon.ico");
    // }
}
