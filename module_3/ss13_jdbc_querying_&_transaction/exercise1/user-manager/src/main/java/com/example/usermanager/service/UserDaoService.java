package com.example.usermanager.service;

import com.example.usermanager.model.User;
import com.example.usermanager.repository.IUserDAO;
import com.example.usermanager.repository.UserDAO;

import java.util.List;

public class UserDaoService implements IUserDAOService {
    private static final IUserDAO USER_DAO = new UserDAO();
    @Override
    public void addUser(User user) {
        USER_DAO.insertUser(user);
    }

    @Override
    public User getUser(int id) {
        return USER_DAO.selectUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return USER_DAO.selectAllUsers();
    }

    @Override
    public boolean removeUser(int id) {
        return USER_DAO.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) {
        return USER_DAO.updateUser(user);
    }

    @Override
    public List<User> findUser(String country) {
        return USER_DAO.findUsers(country);
    }

    @Override
    public List<User> sortList() {
        return USER_DAO.sortList();
    }
}
