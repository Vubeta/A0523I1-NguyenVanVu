package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Order;
import com.example.demo.model.OrderDetail;
import com.example.demo.model.Product;
import com.example.demo.service.order.IOrderService;
import com.example.demo.service.order_detail.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
@SessionAttributes("cart")
public class OrderController {
    @Autowired
    IOrderService iOrderService;

    @Autowired
    IOrderDetailService iOrderDetailService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/checkout")
    public String checkout(@ModelAttribute("cart") Cart cart,
                           Model model){
        Order order = new Order();
        iOrderService.saveOrder(order);
        order.setTotalAmount(cart.countTotalPayment());
        List<OrderDetail> orderDetailList = new ArrayList<>();
        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setProduct(entry.getKey());
            orderDetail.setQuantity(entry.getValue());
            orderDetailList.add(orderDetail);
            iOrderDetailService.save(orderDetail);
        }
        order.setOrderItems(orderDetailList);
        model.addAttribute("order", order);
        return "checkout";
    }

    @PostMapping("/place-order")
    public String placeOrder(@SessionAttribute("cart") Cart cart,
                             @ModelAttribute("order") Order order,
                             Model model){
        cart.getProducts().clear();
        iOrderService.saveOrder(order);
        model.addAttribute("order", order);
        return "order-confirmation";
    }
}
