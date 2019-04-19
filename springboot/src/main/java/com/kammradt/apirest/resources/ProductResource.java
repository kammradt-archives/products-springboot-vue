package com.kammradt.apirest.resources;

import com.kammradt.apirest.models.Product;
import com.kammradt.apirest.repository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Products")
@CrossOrigin(origins = "*")

public class ProductResource {

    @Autowired
    ProductRepository productRepository;

    // Get
    @GetMapping("/get/products")
    @ApiOperation(value = "Return a list of all products")
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/get/product/{id}")
    @ApiOperation(value = "Return a single product by it's ID")
    public Product getProduct(@PathVariable(value="id") long id){
        return productRepository.findById(id);
    }

    // Post
    @PostMapping("/post/product")
    @ApiOperation(value = "Insert a new product")
    public Product postProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @PostMapping("/post/products")
    @ApiOperation(value = "Insert a list of new product")
    public List<Product> postProduct(@RequestBody List<Product> products){
        return productRepository.saveAll(products);
    }

    // Delete
    @DeleteMapping("/delete/product/{id}")
    @ApiOperation(value = "Delete a single product by it's ID")
    public void deleteProduct(@PathVariable(value="id") long id){
        productRepository.deleteById(id);
    }

    @DeleteMapping("/delete/products/{ids}")
    @ApiOperation(value = "Delete a list of products by their IDs")
    public void deleteProducts(@PathVariable(value="ids") Long[] ids){
        for (Long id: ids) {
            productRepository.deleteById(id);
        }

    }

    //Put
    @PutMapping("/put/product")
    @ApiOperation(value = "Update single product")
    public Product putProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping("/put/products")
    @ApiOperation(value = "Update a list of products")
    public List<Product> putProducts(@RequestBody List<Product> products){
        return productRepository.saveAll(products);
    }
}
