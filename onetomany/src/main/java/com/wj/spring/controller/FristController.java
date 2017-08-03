package com.wj.spring.controller;

import com.wj.spring.entity.Order;
import com.wj.spring.entity.OrderItem;
import com.wj.spring.repository.OrderItemRepository;
import com.wj.spring.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FristController {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/add")
    public OrderItem addUser() {
        Order order = new Order();
        order.setAmount(5F);
        order = orderRepository.save(order);
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setProductName("wangjinProductName");
        orderItem.setSellPrice(500F);
        return orderItemRepository.save(orderItem);
    }
}
