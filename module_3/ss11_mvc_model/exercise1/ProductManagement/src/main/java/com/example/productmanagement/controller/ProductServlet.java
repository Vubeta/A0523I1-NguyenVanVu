package com.example.productmanagement.controller;

import com.example.productmanagement.service.IProductService;
import com.example.productmanagement.service.ProductServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private final IProductService PRODUCT_SERVICE = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                break;
            case "edit":
                break;
            case "delete":
                break;
            case "view":
                break;
            default:
                listProducts(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
