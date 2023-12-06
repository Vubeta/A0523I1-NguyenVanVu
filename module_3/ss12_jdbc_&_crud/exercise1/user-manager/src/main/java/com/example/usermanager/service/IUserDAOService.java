package com.example.usermanager.service;

import com.example.usermanager.model.User;

import java.util.List;

public interface IUserDAOService {
    void addUser(User user);
    User getUser(int id);
    List<User> getAllUsers();
    boolean removeUser(int id);
    boolean updateUser(User user);
    List<User> findUser(String country);
    List<User> sortList();
}
