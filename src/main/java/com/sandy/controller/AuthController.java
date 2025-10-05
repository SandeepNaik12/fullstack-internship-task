package com.sandy.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sandy.entity.Product;
import com.sandy.entity.User;
import com.sandy.service.ProductService;
import com.sandy.service.UserService;

@Controller
public class AuthController {
	
		private final UserService userService;
		
	
		public AuthController(UserService userService) {
			this.userService=userService;
		}
		
		@GetMapping("/login")
		public String loginPage() {
			return "login";
		}
		
		@GetMapping("/register")
		public String registerUser(Model model) {
			model.addAttribute("user", new User());
			return "register";
		}
		
		@PostMapping("/register")
		public String registerUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
		    userService.registerUser(user);
		    redirectAttributes.addFlashAttribute("msg", "Registration successful! Please login.");
		    return "redirect:/login";
		}

}
