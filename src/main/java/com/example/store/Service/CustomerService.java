package com.example.store.Service;

import com.example.store.Api.ApiException;
import com.example.store.Model.Customer;
import com.example.store.Model.Product;
import com.example.store.Repository.CustomerRepository;
import com.example.store.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public void addCustomer(Customer newCustomer){
        customerRepository.save(newCustomer);

    }

    public void updateCustomer(Integer id, Customer customer){
       Customer customer1 = customerRepository.findCustomerBy(id);

       if(customer1 == null){
           throw new ApiException("not found");
       }
       customer1.setName(customer.getName());
       customer1.setEmail(customer.getEmail());
       customer1.setAddress(customer.getAddress());
       customer1.setPassword(customer.getPassword());
       customer1.setPhoneNumber(customer.getPhoneNumber());
       customerRepository.save(customer1);

    }

    public void deleteCustomer(Integer id){
        Customer customer = customerRepository.findCustomerBy(id);

        if(customer == null){
            throw new ApiException("not found");
        }
        customerRepository.delete(customer);
    }
    public Customer searchCustomerByNumber(String phoneNumber){
        Customer customer = customerRepository.findCustomerByPhoneNumber(phoneNumber);

        if(customer == null){
            throw new ApiException("not found");
        }
        return customer;
    }
    public List<Customer> getCustomersByCity(String city){
        List<Customer> customers = customerRepository.findCustomerByAddressContaining(city);

        if(customers == null){
            throw new ApiException("not found");
        }
        return customers;
    }



    public void buyProduct(Integer productId, Integer customerId){
        Product product = productRepository.findProductById(productId);
        Customer customer = customerRepository.findCustomerBy(customerId);
        if (product.getQuantity() == 0){
            throw new ApiException("not available");
        }
        if (product.getPrice() > customer.getBalance()){
            throw new ApiException("you do not have enough money");

        }
        product.setQuantity(product.getQuantity()-1);
        customer.setBalance(customer.getBalance()-product.getPrice());
        productRepository.save(product);
        customerRepository.save(customer);
        if (product.getQuantity() == 0){
            product.setIsAvailable(false);
            productRepository.save(product);
        }

    }
//    public List<Product> getPurchaseHistory(List<Product>  purchaseHistoryList){
//
//       return purchaseHistoryList;
//
//    }


}
