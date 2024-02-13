package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller
@RequestMapping("/product")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/")
    public String show(@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
                       Model model){
        Pageable pageable = PageRequest.of(page, 5);
        Page<Product> products = iProductService.findAll(pageable);
        model.addAttribute("products", products);
        return "/show";
    }

    @GetMapping("/form-create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("/create", "product", new Product());
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("product") Product product){
        product.setProductCode(randomProductCode());
        iProductService.save(product);
        return "redirect:/product/";
    }

    @GetMapping("/{id}/view/{count}")
    public String showView(@PathVariable("id") int id, @PathVariable("count") int count, Model model){
        Product product = iProductService.findById(id);
        model.addAttribute("product", product);
        model.addAttribute("count", count);
        return "/view";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Integer id, @ModelAttribute("cart") Cart cart) {
        Product product = iProductService.findById(id);
        if (product == null) {
            return "/error_id_false";
        }
        cart.addProduct(product);
        return "redirect:/shopping-cart";
    }

    @GetMapping("/update/cart/{id}/{action}")
    public String updateCard(@PathVariable("id") Integer id, @PathVariable("action") String action,
                             @ModelAttribute("cart") Cart cart) {
        Product product = iProductService.findById(id);
        if (action.equals("decrease")) {
            cart.reduceProduct(product);
        } else if (action.equals("increase")) {
            cart.addProduct(product);
        } else if (action.equals("remove")) {
            cart.removeProduct(product);
        }
        return "redirect:/shopping-cart";
    }

    private String randomProductCode(){
        int codeLength = 4;
        StringBuilder sb = new StringBuilder(codeLength);
        Random random = new Random();

        do {
            for (int i = 0; i < codeLength; i++) {
                int randomNum = random.nextInt(10);
                sb.append(randomNum);
            }
        } while (iProductService.findByCode(sb.toString()) != null);

        return sb.toString();
    }
}
