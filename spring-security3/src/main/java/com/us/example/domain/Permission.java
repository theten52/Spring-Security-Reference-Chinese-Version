package com.us.example.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ss3_permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    //权限名称
    @Column(name = "name")
    private String name;

    //权限描述
    @Column(name = "descritpion")
    private String descritpion;

    //授权链接
    @Column(name = "url")
    private String url;

    //父节点id
    @Column(name = "pid")
    private int pid;

    //请求方法
    @Column(name = "method")
    private String method;

    // @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    // @JoinTable(name="ss3_role_permission",joinColumns={@JoinColumn(name="p_id")},inverseJoinColumns={@JoinColumn(name="r_id")})
    // private Set<SysRole> sysRoles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    // public Set<SysRole> getSysRoles() {
    //     return sysRoles;
    // }
    //
    // public void setSysRoles(Set<SysRole> sysRoles) {
    //     this.sysRoles = sysRoles;
    // }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descritpion='" + descritpion + '\'' +
                ", url='" + url + '\'' +
                ", pid=" + pid +
                ", method='" + method + '\'' +
                // ", sysRoles=" + sysRoles +
                '}';
    }
}
