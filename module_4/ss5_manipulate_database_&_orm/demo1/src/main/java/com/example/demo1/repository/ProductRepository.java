package com.example.demo1.repository;

import com.example.demo1.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    private final String GET_ALL_PRODUCTS = "select p from Product p where p.productStatus = true order by p.productId";
    private final String SELECT_PRODUCT_BY_NAME = "select p from Product p where p.productName like :name";
    private final String SELECT_PRODUCT_BY_ID = "select p from Product p where p.productId = :id";
    @Override
    public List<Product> selectAllProducts() {
        TypedQuery<Product> query = entityManager.createQuery(GET_ALL_PRODUCTS, Product.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product selectProduct(int productId) {
        TypedQuery<Product> query = entityManager.createQuery(SELECT_PRODUCT_BY_ID,Product.class);
        query.setParameter("id",productId);
        return query.getSingleResult();
    }

    @Override
    public List<Product> findProductByName(String productNameInput) {
        TypedQuery<Product> query = entityManager.createQuery(SELECT_PRODUCT_BY_NAME, Product.class);
        query.setParameter("name","%" + productNameInput + "%");
        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        entityManager.merge(product);
    }

    @Override
    @Transactional
    public void deleteProduct(int productId) {
        Product product = entityManager.find(Product.class,productId);
        if (product != null) {
            product.setProductStatus(false);
            entityManager.merge(product);
        }
    }

//    @Override
//    @Transactional
//    public void deleteProduct(Product product) {
//        entityManager.remove(entityManager.contains(product) ? product : entityManager.merge(product));
//    }
//
//    @Override
//    @Transactional
//    public void deleteProductById(int productId) {
//        Product product = entityManager.find(Product.class, productId);
//        if (product != null) {
//            entityManager.remove(product);
//        }
//    }
}
