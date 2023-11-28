package com.example.displaylistcustomer;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

@WebServlet(name = "ListCustomer", value = "/ListCustomer")
public class ListCustomer extends HttpServlet {
    public static final ArrayList<Customer> LIST_CUSTOMER = new ArrayList<>();

    static {
        LIST_CUSTOMER.add(new Customer("Mai Văn Hoàn", LocalDate.of(1983, 8, 20), "Hà Nội", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRnKXpdoiybxzjWgzqMqapBSxzdoQkdPPXMSA&usqp=CAU"));
        LIST_CUSTOMER.add(new Customer("Nguyễn Văn Nam", LocalDate.of(1983, 8, 21), "Bắc Giang", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSSR9eTrIu2bv6rUz2vL2UkbJzO_iP5n0YtKA&usqp=CAU"));
        LIST_CUSTOMER.add(new Customer("Nguyễn Thái Hòa", LocalDate.of(1983, 8, 22), "Nam Định", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR-4BWvcIPw_CpP7EZ70TCXcJC_jkwMzzWx1w&usqp=CAU"));
        LIST_CUSTOMER.add(new Customer("Trần Đăng Khoa", LocalDate.of(1983, 8, 17), "Hà Tây", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfdHmhB3j4oyJOebNd5J7VJzujDUEqb_Ufqw&usqp=CAU"));
        LIST_CUSTOMER.add(new Customer("Nguyễn Đình Thi", LocalDate.of(1983, 8, 19), "Hà Nội", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcStq5aP7C4Q1LDDOLSqI9TflV2X1Od1FWFevw&usqp=CAU"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //show result
        request.setAttribute("LIST_CUSTOMER", LIST_CUSTOMER);
        //forward data
        for (Customer customer:LIST_CUSTOMER) {
            System.out.println(customer);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
