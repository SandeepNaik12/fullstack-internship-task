package com.sandy.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sandy.entity.Product;
import com.sandy.service.ProductService;

@Controller
public class HomeController {

		private final ProductService productService;
		
		
		public HomeController(ProductService productService) {
			this.productService=productService;
		}		
				
		@GetMapping({"/","/index"})
		public String getHome(Model model,Principal principal) {
			List<Product> product = productService.getProduct();
			model.addAttribute("product", new Product());
			model.addAttribute("products", product);
			model.addAttribute("user", principal != null ? principal.getName() : null);
			return "index";
		}
	
}
