package com.wj.springsecurity.configuration;

import com.wj.springsecurity.entity.UserAuthority;
import com.wj.springsecurity.entity.UserInfo;
import com.wj.springsecurity.service.SUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired  //数据库服务类
    private SUserService suserService;

    /**
     * 重写loadUserByUsername方法，从数据库中取出用户信息。最后返回一个UserDetails 实现类。
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //UserInfo对应数据库中的用户表，是最终存储用户和密码的表，可自定义
        //本例使用UserInfo中的email作为用户名:
        UserInfo user = suserService.findUserByEmail(userName);

        if (user == null) {
            throw new UsernameNotFoundException("UserName " + userName + " not found");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
        for (UserAuthority role : user.getUserAuthoritySet()) {
            authorities.add(new SimpleGrantedAuthority(role.getUserAuthority()));
            System.out.println(role.getUserAuthority());
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(), authorities);


        // SecurityUser实现UserDetails并将SUser的Email映射为username
        // SecurityUser securityUser = new SecurityUser(user);
        // Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        // authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        // return securityUser;
    }
}
