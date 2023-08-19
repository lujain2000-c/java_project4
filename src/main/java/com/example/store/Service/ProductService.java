package com.example.store.Service;

import com.example.store.Api.ApiException;
import com.example.store.Model.Customer;
import com.example.store.Model.Product;
import com.example.store.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public void addProduct(Product newProduct){
        productRepository.save(newProduct);

    }

    public void updateProduct(Integer id, Product product){
        Product product1 = productRepository.findProductById(id);

        if(product1 == null){
            throw new ApiException("not found");
        }
        product1.setName(product.getName());
        product1.setQuantity(product.getQuantity());
        product1.setColor(product.getColor());
        product1.setPrice(product.getPrice());
        product1.setCategory(product.getCategory());
        product1.setIsAvailable(product.getIsAvailable());
        productRepository.save(product1);

    }

    public void deleteProduct(Integer id){
        Product product = productRepository.findProductById(id);

        if(product == null){
            throw new ApiException("not found");
        }
        productRepository.delete(product);
    }

    public List<Product> getAllAvailableProduct(){
         List<Product> products = productRepository.findByIsAvailableTrue();
        if (products == null){
            throw new ApiException("NOT FOUND");
        }

        return products;
    }

    public Product searchByName(String name){
        Product product = productRepository.findProductByName(name);
        if (product == null){
            throw new ApiException("NOT FOUND");
        }

        return product;
    }
    public List<Product> searchByColor(String color){
        List<Product> products = productRepository.findProductByColor(color);

        if (products == null){
            throw new ApiException("NOT FOUND");
        }

        return products;
    }

    public List<Product> searchByCategory(String category){
        List<Product> products = productRepository.findProductByCategory(category);

        if (products == null){
            throw new ApiException("NOT FOUND");
        }

        return products;
    }

    public List<Product> searchByPriceLessThan(Double price){
        List<Product> products = productRepository.findProductByPriceLessThan(price);

        if (products == null){
            throw new ApiException("NOT FOUND");
        }

        return products;
    }
    public List<Product> searchByPriceGreaterThan(Double price){
        List<Product> products = productRepository.findProductByPriceGreaterThan(price);

        if (products == null){
            throw new ApiException("NOT FOUND");
        }

        return products;
    }

    public List<Product> orderByPriceAsc(){
        List<Product> products = productRepository.findProductByPriceOrderByPriceAsc();

        if (products == null){
            throw new ApiException("NOT FOUND");
        }

        return products;
    }

}
