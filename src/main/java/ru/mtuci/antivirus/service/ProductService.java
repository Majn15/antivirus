package ru.mtuci.antivirus.service;

import ru.mtuci.antivirus.models.Products;
import ru.mtuci.antivirus.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductsRepository productRepository;

    public List<Products> findAll() {
        return productRepository.findAll();
    }

    public Optional<Products> findById(Long id) {
        return productRepository.findById(id);
    }

    public Optional<Products> findByName(String name) {
        return productRepository.findByName(name);
    }

    public Products save(Products product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}

