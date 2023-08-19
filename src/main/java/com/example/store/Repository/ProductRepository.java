package com.example.store.Repository;

import com.example.store.Model.Customer;
import com.example.store.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("select p from Product p where p.name = ?1")
    Product findProductByName(String name);
    @Query("select p from Product p where p.isAvailable = true")
    List<Product> findByIsAvailableTrue();

   @Query("select p from Product p where p.color = ?1")
    List<Product> findProductByColor(String color);
    @Query("select p from Product p where p.category = ?1")
    List<Product> findProductByCategory(String category);
    @Query("select p from Product p where p.price = ?1")
    List<Product> findProductByPriceLessThan(Double price);
    @Query("select p from Product p where p.price = ?1")
    List<Product> findProductByPriceGreaterThan(Double price);
    @Query("select p from Product p where p.id = ?1")
    Product findProductById(Integer id);

    @Query("select p from Product p  order by p.price asc ")
    List<Product> findProductByPriceOrderByPriceAsc();
}

