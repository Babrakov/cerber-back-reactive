package ru.infoza.cerberback.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import ru.infoza.cerberback.model.Product;


@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
}
