package com.sandy.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sandy.entity.Product;
import com.sandy.repositary.ProductRepository;

@Component
public class ProductService {
		
		private final ProductRepository productRepositiory;
		
		public ProductService(ProductRepository productRepositiory) {
			this.productRepositiory=productRepositiory;
		}

		public void addProduct(Product product) {
			productRepositiory.save(product);
			
		}

		public List<Product> getProduct() {
			List<Product> products = productRepositiory.findAll();
			return products;
			
		}

		public Product findById(Long id) {
			
			return productRepositiory.findProductById(id);
		}

		public Product save(Product product) {
			
			return productRepositiory.save(product);
		}

		public boolean deleteProduct(Long id) {
			if (productRepositiory.existsById(id)) {
				productRepositiory.deleteById(id);
	            return true;
	        }
	        return false;
		}
}
