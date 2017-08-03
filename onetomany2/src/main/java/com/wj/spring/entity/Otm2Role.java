package com.wj.spring.entity;

import javax.persistence.*;

@Entity
@Table(name="otm2_role")
public class Otm2Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="role_id")
    private Long role_id;

    @Column(name="role_name")
    private String role_name;

    @ManyToOne(cascade=CascadeType.ALL,fetch= FetchType.EAGER)
    @JoinColumn(name="user_id")//加入一列作为外键
    private Otm2User otm2User;

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

    public Otm2User getOtm2User() {
        return otm2User;
    }

    public void setOtm2User(Otm2User otm2User) {
        this.otm2User = otm2User;
    }

}
