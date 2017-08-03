package com.wj.springsecurity.entity;

import javax.persistence.*;

@Entity
@Table(name = "ss_user_authority")
public class UserAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")//加入一列作为外键
    private UserInfo user;

    @Column(name = "user_authority")
    private String userAuthority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserAuthority() {
        return userAuthority;
    }

    public void setUserAuthority(String userAuthority) {
        this.userAuthority = userAuthority;
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
                "id=" + id +
                ", userAuthority='" + userAuthority + '\'' +
                ", user=" + user +
                '}';
    }
}
