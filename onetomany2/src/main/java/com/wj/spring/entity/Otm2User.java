package com.wj.spring.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="otm2_user")
public class Otm2User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

    /*
     * cascade：为级联操作，里面有级联保存，级联删除等，all为所有
     * fetch：加载类型，有lazy和eager二种，
     *   eager为急加载，意为立即加载，在类加载时就加载，lazy为慢加载，第一次调用的时候再加载，由于数据量太大，onetomany一般为lazy
     * mappedBy：这个为manytoone中的对象名，这个不要变哦
     * Set<role>：这个类型有两种，一种为list另一种为set
     */
    @OneToMany(cascade=CascadeType.ALL,fetch= FetchType.LAZY,mappedBy="otm2User")
    private Set<Otm2Role> setOtm2Role;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Otm2Role> getSetOtm2Role() {
        return setOtm2Role;
    }

    public void setSetOtm2Role(Set<Otm2Role> setOtm2Role) {
        this.setOtm2Role = setOtm2Role;
    }

}