package com.example.productmanagement.controller;

import com.example.productmanagement.model.Product;
import com.example.productmanagement.service.IProductService;
import com.example.productmanagement.service.ProductServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product-servlet")
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
                showFormCreate(request,response);
                break;
            case "update":
                showFormUpdate(request,response);
                break;
            case "remove":
                showFormRemove(request,response);
                break;
            case "detail":
                showFormDetails(request,response);
                break;
            default:
                listProducts(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                addNewProduct(request,response);
                break;
            case "update":
                editProduct(request,response);
                break;
            case "remove":
                removeProduct(request,response);
                break;
            case "search":
                showFormSearch(request,response);
                break;
            default:
                listProducts(request,response);
        }

    }

    //show list product
    private void listProducts(HttpServletRequest request, HttpServletResponse response) {
        //get data
        List<Product> products = this.PRODUCT_SERVICE.showAll();
        //define data
        request.setAttribute("products",products);
        //forward result
        RequestDispatcher dispatcher = request.getRequestDispatcher("/display-product-list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    // create product
    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        //redirect
        RequestDispatcher dispatcher = request.getRequestDispatcher("/create-product.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void addNewProduct(HttpServletRequest request, HttpServletResponse response) {
        //get data
        String productId = request.getParameter("productId");
        String productName = request.getParameter("productName");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        String productDetail = request.getParameter("productDetail");
        String producer = request.getParameter("producer");
        //create product
        Product product = new Product(productId,productName,productPrice,productDetail,producer);
        //add new product
        PRODUCT_SERVICE.addProduct(product);
        //redirect
        try {
            response.sendRedirect("/product-servlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //update product
    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) {
        //get data
        String productId = request.getParameter("productId");
        //data processing
        Product product = PRODUCT_SERVICE.getProduct(productId);
        String productName = product.getProductName();
        double productPrice = product.getProductPrice();
        String productDetail = product.getProductDescription();
        String producer = product.getProducer();
        //define data
        request.setAttribute("productId",productId);
        request.setAttribute("productName",productName);
        request.setAttribute("productPrice",productPrice);
        request.setAttribute("productDetail",productDetail);
        request.setAttribute("producer",producer);
        //forward data
        RequestDispatcher dispatcher = request.getRequestDispatcher("/update-product.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        //get data
        String originalProductId = request.getParameter("productId");
        String productName = request.getParameter("productName");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        String productDetail = request.getParameter("productDetail");
        String producer = request.getParameter("producer");
        // data processing
        Product product = new Product(originalProductId,productName,productPrice,productDetail,producer);
        PRODUCT_SERVICE.updateProduct(originalProductId,product);
        //redirect
        try {
            response.sendRedirect("/product-servlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    remove product
    private void showFormRemove(HttpServletRequest request, HttpServletResponse response) {
        //get data
        String productId = request.getParameter("productId");
        //data processing
        Product product = PRODUCT_SERVICE.getProduct(productId);
        String productName = product.getProductName();
        double productPrice = product.getProductPrice();
        String productDetail = product.getProductDescription();
        String producer = product.getProducer();
        //define data
        request.setAttribute("productId",productId);
        request.setAttribute("productName",productName);
        request.setAttribute("productPrice",productPrice);
        request.setAttribute("productDetail",productDetail);
        request.setAttribute("producer",producer);
        //forward data
        RequestDispatcher dispatcher = request.getRequestDispatcher("/remove-product.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void removeProduct(HttpServletRequest request, HttpServletResponse response) {
        //get data
        String productId = request.getParameter("productId");
        // data processing
        PRODUCT_SERVICE.deleteProduct(productId);
        //redirect
        try {
            response.sendRedirect("/product-servlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //show product details
    private void showFormDetails(HttpServletRequest request, HttpServletResponse response) {
        //get data
        String productId = request.getParameter("productId");
        //data processing
        Product product = PRODUCT_SERVICE.getProduct(productId);
        String productName = product.getProductName();
        double productPrice = product.getProductPrice();
        String productDetail = product.getProductDescription();
        String producer = product.getProducer();
        //define data
        request.setAttribute("productId",productId);
        request.setAttribute("productName",productName);
        request.setAttribute("productPrice",productPrice);
        request.setAttribute("productDetail",productDetail);
        request.setAttribute("producer",producer);
        //forward data
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product-details.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    //search by product name
    private void showFormSearch(HttpServletRequest request, HttpServletResponse response) {
        //get data
        String productName = request.getParameter("productName");
        //data processing
        List<Product> products = PRODUCT_SERVICE.findProduct(productName);
        //define data
        request.setAttribute("productName",productName);
        request.setAttribute("products",products);
        //forward data
        RequestDispatcher dispatcher = request.getRequestDispatcher("/search-product.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
