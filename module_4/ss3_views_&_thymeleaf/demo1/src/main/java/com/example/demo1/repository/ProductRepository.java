package com.example.demo1.repository;

import com.example.demo1.model.Product;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private final String GET_ALL_PRODUCTS = "select * from product where product_status = 1 order by product_id;";
    private final String EDIT_PRODUCT_BY_ID = "update product set product_name = ?, product_price = ?, product_description = ?, producer = ? where product_id = ?";
    private final String DELETE_PRODUCT_BY_ID = "update product set product_status = 0 where product_id = ?;";
    private final String SELECT_PRODUCT_BY_NAME = "select * from product where product_name like ?;";
    private final String SELECT_PRODUCT_BY_ID = "select * from product where product_id = ?;";
    private final String INSERT_PRODUCT = "insert into product (product_name, product_price, product_description, producer) values (?,?,?,?)";
    @Override
    public List<Product> selectAllProducts() {
        List<Product> list = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCTS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                list.add(createProductFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean updateProduct(Product product) {
        return updateProduct(product, EDIT_PRODUCT_BY_ID);
    }

    @Override
    public boolean deleteProduct(int id) {
        boolean isDeleted = false;
        try (Connection connection = BaseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_BY_ID)) {
            preparedStatement.setInt(1,id);
            isDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    @Override
    public List<Product> findProductByName(String productNameInput) {
        List<Product> list = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_NAME)) {
            preparedStatement.setString(1,"%" + productNameInput + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                list.add(createProductFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Product selectProduct(int id) {
        Product product = null;
        try (Connection connection = BaseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID)) {
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                product = createProductFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean insertProduct(Product product) {
        return updateProduct(product,INSERT_PRODUCT);
    }

    private Product createProductFromResultSet(ResultSet rs) throws SQLException {
        int productId = rs.getInt("product_id");
        String productName = rs.getString("product_name");
        double productPrice = rs.getDouble("product_price");
        String productDescription = rs.getString("product_description");
        String producer = rs.getString("producer");
        return new Product(productId, productName, productPrice, productDescription, producer);
    }

    private boolean updateProduct(Product product, String query) {
        boolean isUpdated = false;
        try (Connection connection = BaseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setDouble(2,product.getProductPrice());
            preparedStatement.setString(3,product.getProductDescription());
            preparedStatement.setString(4,product.getProducer());

            if (query.equals(EDIT_PRODUCT_BY_ID)) {
                preparedStatement.setInt(5,product.getProductId());
            }

            isUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }
}
