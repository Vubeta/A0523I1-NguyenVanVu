package com.example.furama_resort_management.controller;

import com.example.furama_resort_management.model.customer.Customer;
import com.example.furama_resort_management.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/")
    public String showCustomers(@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
                                Model model){
        Pageable pageable = PageRequest.of(page, 3);
        Page<Customer> customers = iCustomerService.findAll(pageable);
        model.addAttribute("customers", customers);
        return "/customer/list";
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        return new ModelAndView("/customer/create", "customer", new Customer());
    }

    @PostMapping("/create")
    public String addNewCustomer(Customer customer) {
        iCustomerService.save(customer);
        return "redirect:/customer/";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int customerId) {
        iCustomerService.remove(customerId);
        return "redirect:/customer/";
    }

    @GetMapping("/update/{id}")
    public ModelAndView showFormUpdate(@PathVariable Integer id) {
        return new ModelAndView("/customer/update", "customer", iCustomerService.findById(id));
    }
}
