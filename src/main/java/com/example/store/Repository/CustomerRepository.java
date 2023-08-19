package com.example.store.Repository;

import com.example.store.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query("select c from Customer c where c.id = ?1")
    Customer findCustomerBy(Integer id);
    @Query("select c from Customer c where c.phoneNumber = ?1")
    Customer findCustomerByPhoneNumber(String phoneNumber);

    @Query("select c from Customer c where c.address like %?1%")
    List<Customer> findCustomerByAddressContaining(String city);


}
