package com.wj.spring.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "otm_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "amount",nullable = false)
    private Float amount = 0f;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    //这里配置关系，并且确定关系维护端和被维护端。mappedBy表示关系被维护端，只有关系端有权去更新外键。这里还有注意OneToMany默认的加载方式是赖加载。当看到设置关系中最后一个单词是Many，那么该加载默认为懒加载
    private Set<OrderItem> items  ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }

    /**
     * 该方法用于向order中加order项
     */
    public void addOrderItem(OrderItem orderItem) {
        orderItem.setOrder(this);//用关系维护端来维护关系
        this.items.add(orderItem);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", amount=" + amount +
                ", items=" + items +
                '}';
    }
}