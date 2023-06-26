package com.works.restControllers;

import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import com.works.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductRestController {

    private final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody /*de serialization*/ Product product) {

        return productService.save(product);
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return productService.productList();
    }

    @GetMapping("/deleteProduct/{pid}")
    public ResponseEntity delete(@PathVariable Long pid) {
        return productService.deleteProduct(pid);
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody Product product) {
        return productService.update(product);
    }

}
