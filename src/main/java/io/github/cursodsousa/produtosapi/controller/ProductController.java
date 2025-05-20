package io.github.cursodsousa.produtosapi.controller;

import io.github.cursodsousa.produtosapi.model.Product;
import io.github.cursodsousa.produtosapi.repository.ProductRepository;
import org.aspectj.util.Reflection;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("product")
// name of request in url
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    //Is used to send or save datas
    // post -> save or create data in to server
    //everything what you send or receive to server are called funds
    public Product returnProducts(@RequestBody Product product ){
        System.out.println("Product Received " + product);
        var id  = UUID.randomUUID().toString();
        product.setId(id);
        productRepository.save(product);
        return product;
    }

    @GetMapping("{id}")
    //@GetMapping("{id}/{name}/{another thing}")
    //is used to get data and this -> {} is the parameter and you put the name of same inside of keys
    public Product showProductByID(@PathVariable("id") String id){
        //@PathVariable is used to define parameters and is necessary define the same inside of ()
        // Optional<Product> product = productRepository.findById(id);
        // return product.isPresent() ? product.get() : null;
        return productRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void Delete(@PathVariable("id") String id){
        productRepository.deleteById(id);
        //this method delete things by id
    }
}
