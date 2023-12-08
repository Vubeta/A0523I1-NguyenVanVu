package com.example.usermanager.controller;

import com.example.usermanager.model.User;

import com.example.usermanager.service.IUserDAOService;
import com.example.usermanager.service.UserDaoService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet {
    private static final IUserDAOService USER_DAO_SERVICE = new UserDaoService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            case "search":
                findUser(request,response);
            case "sort":
                sortUsers(request,response);
            default:
                listUser(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertUser(request, response);
                break;
            case "edit":
                updateUser(request, response);
                break;
            default:
                listUser(request, response);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) {
        List<User> listUser = USER_DAO_SERVICE.getAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = USER_DAO_SERVICE.getUser(id);
        request.setAttribute("user", existingUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User(name, email, country);
        USER_DAO_SERVICE.addUser(newUser);
        try {
            response.sendRedirect("/users");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        System.out.println(id + name + email + country);
        User book = new User(id, name, email, country);
        USER_DAO_SERVICE.updateUser(book);
        try {
            response.sendRedirect("/users");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        USER_DAO_SERVICE.removeUser(id);

        List<User> listUser = USER_DAO_SERVICE.getAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void findUser(HttpServletRequest request, HttpServletResponse response) {
        //get data
        String countryName = request.getParameter("countryName");
        //create list
        List<User> usersList = USER_DAO_SERVICE.findUser(countryName);
        //define data
        request.setAttribute("usersListByCountry",usersList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/find.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void sortUsers(HttpServletRequest request, HttpServletResponse response) {
        //create list
        List<User> sortedList = USER_DAO_SERVICE.sortList();
        //define data
        request.setAttribute("listUser",sortedList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
