package pl.doz.DoZproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.doz.DoZproject.service.ProductService;

@RestController
@RequestMapping("/doz/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

}
