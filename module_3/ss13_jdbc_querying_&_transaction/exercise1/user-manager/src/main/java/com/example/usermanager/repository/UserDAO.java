package com.example.usermanager.repository;

import com.example.usermanager.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private final String INSERT_USERS_SQL = "INSERT INTO users" + "(name, email, country) VALUES" + "(?,?,?);";
    private final String SELECT_USER_BY_ID = "select id, name, email, country from users where id = ?";
    private final String SELECT_ALL_USERS = "call users_list();";
    private final String DELETE_USERS_SQL = "call remove_user(?)";
    private final String UPDATE_USERS_SQL = "call update_list(?,?,?,?);";
    private final String FIND_USERS_SQL = "select * from users where country like ?;";
    private final String SORT_USERS_SQL = "select * from users order by substring_index (`name`,' ',-1);";

    public UserDAO() {
    }

    @Override
    public void insertUser(User user) {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = BaseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        try (Connection connection = BaseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnection(); CallableStatement callableStatement = connection.prepareCall(SELECT_ALL_USERS)) {
            System.out.println(callableStatement);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean rowDeleted = false;
        try(Connection connection = BaseRepository.getConnection(); CallableStatement callableStatement = connection.prepareCall(DELETE_USERS_SQL)) {
            callableStatement.setInt(1,id);

            rowDeleted = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public List<User> findUsers(String countryInput) {
        List<User> listUsers = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(FIND_USERS_SQL)) {
            preparedStatement.setString(1,"%" + countryInput + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                listUsers.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listUsers;
    }

    @Override
    public boolean updateUser(User user) {
        boolean rowUpdated = false;
        try(Connection connection = BaseRepository.getConnection(); CallableStatement callableStatement = connection.prepareCall(UPDATE_USERS_SQL)) {
            callableStatement.setInt(1,user.getId());
            callableStatement.setString(2,user.getName());
            callableStatement.setString(3,user.getEmail());
            callableStatement.setString(4,user.getCountry());

            rowUpdated = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public List<User> sortList() {
        List<User> sortedList = new ArrayList<>();
        try(Connection connection = BaseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SORT_USERS_SQL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                sortedList.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sortedList;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            e.printStackTrace(System.err);
            System.err.println("SQLState: " + ((SQLException) e).getSQLState());
            System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
            System.err.println("Message: " + e.getMessage());
            Throwable t = ex.getCause();
            while (t != null) {
                System.out.println("Cause: " + t);
                t = t.getCause();
            }
        }
    }
}
