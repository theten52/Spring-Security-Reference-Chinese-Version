package com.wj.spring.entity;

import javax.persistence.*;

@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="role_id")
    private Long role_id;

    @Column(name="role_name")
    private String role_name;

    @ManyToOne(cascade=CascadeType.ALL,fetch= FetchType.EAGER)
    @JoinColumn(name="user_id")//加入一列作为外键
    private User user;

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
