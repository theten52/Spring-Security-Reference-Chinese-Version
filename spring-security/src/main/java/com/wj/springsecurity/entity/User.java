package com.wj.springsecurity.entity;

import javax.persistence.*;
import java.util.HashSet;

@Entity
@Table(name = "user")
public class User {

    @Id
    // @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    // @Column(name = "authority_id")
    // @OneToMany(cascade = CascadeType.ALL, mappedBy = "user_id")
    //原本关系会在第三张表里维护,现在设计由UserAuthority的user_id来维护
    // @OneToMany(cascade = CascadeType.ALL)
    //这里配置关系，并且确定关系维护端和被维护端。mappedBy表示关系被维护端，只有关系端有权去更新外键。这里还有注意OneToMany默认的加载方式是赖加载。当看到设置关系中最后一个单词是Many，那么该加载默认为懒加载
    // private HashSet<UserAuthority> authorities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (email != null ? !email.equals(user.email) : user.email != null) return false;

        //id不为空时在一下情况返回false:
        //id于比较者id不同;
        //比较id为null;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                // ", authorities=" + authorities +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // public HashSet<UserAuthority> getAuthorities() {
    //     return authorities;
    // }
    //
    // public void setAuthorities(HashSet<UserAuthority> authorities) {
    //     this.authorities = authorities;
    // }
}