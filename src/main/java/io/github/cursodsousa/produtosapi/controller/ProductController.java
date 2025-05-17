package io.github.cursodsousa.produtosapi.controller;

import io.github.cursodsousa.produtosapi.model.Product;
import io.github.cursodsousa.produtosapi.repository.ProductRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    //Is used to send or save datas
    // post -> save or create data in to server
    //everything what you send or receive to server are called funds
    public Product returnProducts(@RequestBody Product pr ){
        System.out.println("Product Received " + pr);
        var id  = UUID.randomUUID().toString();
        pr.setId(id);
        productRepository.save(pr);
        return pr;
    }
}
