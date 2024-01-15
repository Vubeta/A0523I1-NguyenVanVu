package com.example.demo1.controller;

import com.example.demo1.model.Product;
import com.example.demo1.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductRepository productRepository;
    @GetMapping("/")
    public String showForm(Model model){
        List<Product> productList = productRepository.selectAllProducts();
        model.addAttribute("productList",productList);
        return "/show-list";
    }

    @GetMapping("/showFormCreate")
    public String showFormCreate(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/addProduct")
    public String add(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes){
        productRepository.save(product);
        redirectAttributes.addFlashAttribute("msg","Insert new product successfully");
        return "redirect:/product/";
    }

    @GetMapping("/findProduct")
    public String find(@RequestParam("productNameInput") String productNameInput, Model model){
        List<Product> productList = productRepository.findProductByName(productNameInput);
        model.addAttribute("productList",productList);
        return "/show-list";
    }

    @GetMapping("/updateProduct/{id}")
    public String showFormUpdate(@PathVariable Integer id, Model model){
        Product product = productRepository.selectProduct(id);
        model.addAttribute("product", product);
        return "/update";
    }

    @PostMapping("/editProduct")
    public String edit(@ModelAttribute("product") Product product) {
        productRepository.updateProduct(product);
        return "redirect:/product/";
    }

    @PostMapping("/deleteProduct")
    public String delete(@RequestParam("productId") int productId){
        productRepository.deleteProduct(productId);
        return "redirect:/product/";
    }
}
