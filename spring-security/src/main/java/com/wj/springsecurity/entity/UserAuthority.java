package com.wj.springsecurity.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_authority")
public class UserAuthority {

    @Id
    // @GeneratedValue
    @Column(name = "id")
    private String id;

    @Column(name = "authority")
    private String authority;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
