package com.example.demo.service.order_detail;

import com.example.demo.model.OrderDetail;
import com.example.demo.repository.IOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    IOrderDetailRepository iOrderDetailRepository;

    @Override
    public void save(OrderDetail orderDetail) {
        iOrderDetailRepository.save(orderDetail);
    }

    @Override
    public void remove(OrderDetail orderDetail) {
        iOrderDetailRepository.delete(orderDetail);
    }
}
