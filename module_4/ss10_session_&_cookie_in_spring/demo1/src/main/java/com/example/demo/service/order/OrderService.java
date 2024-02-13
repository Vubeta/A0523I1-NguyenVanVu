package com.example.demo.service.order;

import com.example.demo.model.Order;
import com.example.demo.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {
    @Autowired
    IOrderRepository iOrderRepository;

    @Override
    public void saveOrder(Order order) {
        iOrderRepository.save(order);
    }

    @Override
    public void removeOrder(Order order) {
        iOrderRepository.delete(order);
    }
}
