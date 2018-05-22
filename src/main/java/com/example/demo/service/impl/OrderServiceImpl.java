package com.example.demo.service.impl;

import com.example.demo.domain.Order;
import com.example.demo.mapper.order.OrderMapper;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order getOne(Integer id) {
        return orderMapper.getOne(id);
    }
}
