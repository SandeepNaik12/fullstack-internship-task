package com.sandy.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandy.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	Product	findProductById(Long id);
}
