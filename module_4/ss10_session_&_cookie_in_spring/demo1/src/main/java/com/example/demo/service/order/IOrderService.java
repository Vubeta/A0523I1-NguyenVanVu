package com.example.demo.service.order;

import com.example.demo.model.Order;

public interface IOrderService {
    void saveOrder(Order order);
    void removeOrder(Order order);
}
