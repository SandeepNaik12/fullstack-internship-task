package com.sandy.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public PasswordEncoder passwordEncoder()
	
	{
		return new BCryptPasswordEncoder();
	}
	
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/", "/index", "/register", "/login", "/css/**", "/js/**").permitAll()
	            .requestMatchers("/product", "/products/delete", "/product/update").authenticated()
	            .anyRequest().permitAll()
	        )
	        .formLogin(login -> login
	            .loginPage("/login")
	            .defaultSuccessUrl("/index", true)
	            .failureUrl("/login?error=true")
	            .permitAll()
	        )
	        .logout(logout -> logout
	            .logoutSuccessUrl("/index?logout=true")
	            .permitAll()
	        );

	    return http.build();
	}

}
