package com.wj.springsecurity.entity;

import javax.persistence.*;

@Entity
@Table(name = "ss_user_authority")
public class UserAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "authority")
    private String authority;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")//加入一列作为外键
    private UserInfo user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserAuthority{" +
                "id='" + id + '\'' +
                ", authority='" + authority + '\'' +
                ", user=" + user +
                '}';
    }
}
