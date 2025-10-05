package com.sandy.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sandy.entity.Product;
import com.sandy.service.ProductService;

@Controller
public class ProductController {

		private final ProductService productService;
		
		public ProductController(ProductService productService) {
			this.productService=productService;
		}
	
		@GetMapping("/product")
		public String products(Model model) {
			model.addAttribute("product", new Product());
			return "index";
		}
		
		@PostMapping("/product")
		public String addProduct(@ModelAttribute Product product) {
			productService.addProduct(product);
			return "redirect:/index";
		}
		
		// Controller method for updating product
		@PutMapping("/product/update/{id}")
		@ResponseBody
		public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
		    Product product = productService.findById(id);
		    product.setName(updatedProduct.getName());
		    product.setPrice(updatedProduct.getPrice());
		    product.setDescription(updatedProduct.getDescription());
		    product.setCategory(updatedProduct.getCategory());
		    product.setImageUrl(updatedProduct.getImageUrl());
		    return productService.save(product); // return updated product as JSON
		}
		
		 @DeleteMapping("/products/delete/{id}")
		    public ResponseEntity<Map<String, Object>> deleteProduct(@PathVariable Long id) {
		        Map<String, Object> response = new HashMap<>();

		        boolean deleted = productService.deleteProduct(id);
		        if (deleted) {
		            response.put("success", true);
		            response.put("message", "Product deleted successfully!");
		            return ResponseEntity.ok(response);
		        } else {
		            response.put("success", false);
		            response.put("message", "Product not found or already deleted.");
		            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		        }
		    }
}
