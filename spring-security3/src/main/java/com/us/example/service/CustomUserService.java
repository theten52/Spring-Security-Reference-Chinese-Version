package com.us.example.service;

import com.us.example.domain.Permission;
import com.us.example.domain.SysRole;
import com.us.example.domain.SysUser;
import com.us.example.repository.RoleRepository;
import com.us.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyibo on 17/1/18.
 */
@Service
public class CustomUserService implements UserDetailsService { //自定义UserDetailsService 接口

    private final UserRepository userRepository;
    private final RoleRepository sysRoleRepository;

    @Autowired
    public CustomUserService(UserRepository userRepository, RoleRepository sysRoleRepository) {
        this.userRepository = userRepository;
        this.sysRoleRepository = sysRoleRepository;
    }

    public UserDetails loadUserByUsername(String username) {
        SysUser user = userRepository.findFirstByUsername(username);
        if (user != null) {
            ArrayList<SysRole> sysRoles = sysRoleRepository.findAllBySysUser(user);
            List<Permission> permissions = new ArrayList<Permission>();
            for (SysRole role : sysRoles) {
                for (Object p : role.getPermissions()) {
                    permissions.add((Permission) p);
                }
            }
            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            for (Permission permission : permissions) {
                if (permission != null && permission.getName() != null) {

                    GrantedAuthority grantedAuthority = new MyGrantedAuthority(permission.getUrl(), permission.getMethod());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }

}
