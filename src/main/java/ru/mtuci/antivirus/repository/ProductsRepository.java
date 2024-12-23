package ru.mtuci.antivirus.repository;

import ru.mtuci.antivirus.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Products, Long> {
    Optional<Products> findByName(String name);
}
