package com.example.demo.service.order_detail;

import com.example.demo.model.OrderDetail;

public interface IOrderDetailService {
    void save(OrderDetail orderDetail);
    void remove(OrderDetail orderDetail);
}
