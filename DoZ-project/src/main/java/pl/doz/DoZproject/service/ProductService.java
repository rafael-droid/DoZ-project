package pl.doz.DoZproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.doz.DoZproject.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
}
