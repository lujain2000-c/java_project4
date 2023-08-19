package com.example.store.Controller;

import com.example.store.Api.ApiResponse;
import com.example.store.Model.Customer;
import com.example.store.Model.Product;
import com.example.store.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/store/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping("/get")
    public ResponseEntity getAllProduct(){
        return ResponseEntity.status(200).body(productService.getAllProduct());
    }

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody @Valid Product newProduct){
        productService.addProduct(newProduct);
        return ResponseEntity.status(200).body(new ApiResponse("added"));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody @Valid Product product){
        productService.updateProduct(id,product);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id){

        productService.deleteProduct(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));

    }

    @GetMapping("/getbyname/{name}")
    public ResponseEntity getByName(@PathVariable String name ){
        return ResponseEntity.status(200).body(productService.searchByName(name));
    }
    @GetMapping("/getbycolor/{color}")
    public ResponseEntity getByColor(@PathVariable String color ){
        return ResponseEntity.status(200).body(productService.searchByColor(color));
    }
    @GetMapping("/getbycategory/{category}")
    public ResponseEntity getByCategory(@PathVariable String  category ){
        return ResponseEntity.status(200).body(productService.searchByCategory(category));
    }

    @GetMapping("/getpricelessthan/{price}")
    public ResponseEntity getByPriceLessThan(@PathVariable Double  price ){
        return ResponseEntity.status(200).body(productService.searchByPriceLessThan(price));
    }
    @GetMapping("/getpricegreaterthan/{price}")
    public ResponseEntity getByPriceGreaterThan(@PathVariable Double price ){
        return ResponseEntity.status(200).body(productService.searchByPriceGreaterThan(price));
    }

    @GetMapping("/getbyavailable")
    public ResponseEntity getAllAvailableProduct(){
        return ResponseEntity.status(200).body(productService.getAllAvailableProduct());
    }
    @GetMapping("/getorderbyprice")
    public ResponseEntity getorderByPriceAsc(){
        return ResponseEntity.status(200).body(productService.orderByPriceAsc());
    }






}
