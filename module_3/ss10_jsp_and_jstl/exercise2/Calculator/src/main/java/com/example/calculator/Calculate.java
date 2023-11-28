package com.example.calculator;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Calculate", value = "/Calculate")
public class Calculate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get data
        double firstOperand = Double.parseDouble(request.getParameter("firstOperand"));
        double secondOperand = Double.parseDouble(request.getParameter("secondOperand"));
        String operator = request.getParameter("operator");

        //calculate
        String result = "";
        String operatorKey = "";
        switch (operator) {
            case "addition":
                result = String.valueOf(firstOperand + secondOperand);
                operatorKey = "+";
                break;
            case "subtraction":
                result = String.valueOf(firstOperand - secondOperand);
                operatorKey = "-";
                break;
            case "multiplication":
                result = String.valueOf(firstOperand * secondOperand);
                operatorKey = "*";
                break;
            case "division":
                operatorKey = "/";
                try {
                    result = String.valueOf(firstOperand / secondOperand);
                    if (result.equals("Infinity"))
                        result = "Error!";
                } catch (ArithmeticException e) {
                    result = "Error!";
                }
                break;
        }

        //show result
        request.setAttribute("firstOperand",firstOperand);
        request.setAttribute("secondOperand",secondOperand);
        request.setAttribute("operatorKey",operatorKey);
        request.setAttribute("result",result);

        //forward data
        RequestDispatcher dispatcher = request.getRequestDispatcher("/calculate.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
