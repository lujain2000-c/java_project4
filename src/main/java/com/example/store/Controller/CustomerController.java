package com.example.store.Controller;

import com.example.store.Api.ApiResponse;
import com.example.store.Model.Customer;
import com.example.store.Service.CustomerService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/store/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/get")
    public ResponseEntity getAllCustomer(){
        return ResponseEntity.status(200).body(customerService.getAllCustomer());
    }
    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody @Valid Customer newCustomer){
        customerService.addCustomer(newCustomer);
        return ResponseEntity.status(200).body(new ApiResponse("added"));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@PathVariable Integer id, @RequestBody @Valid Customer customer){
        customerService.updateCustomer(id,customer);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id){

        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));

    }

    @GetMapping("/getbyphone/{phoneNumber}")
    public ResponseEntity getCustomerByPhoneNumber(@PathVariable String phoneNumber){
        return ResponseEntity.status(200).body(customerService.searchCustomerByNumber(phoneNumber));
    }
    @GetMapping("/getbyaddress/{city}")
    public ResponseEntity getCustomersByCity(@PathVariable String city){
        return ResponseEntity.status(200).body(customerService.getCustomersByCity(city));
    }

    @PostMapping("/buy/{productId}/{customerId}")
    public ResponseEntity buyProduct(@PathVariable Integer productId, @PathVariable Integer customerId){

        customerService.buyProduct(productId,customerId);
        return ResponseEntity.status(200).body(new ApiResponse(" purchase completed successfully"));

    }

}
