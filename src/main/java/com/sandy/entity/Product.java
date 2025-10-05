package com.sandy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		private String name;
		private float  price;
		private String category;
		private String description;
		private String imageUrl;
		
		public Product() {
			// TODO Auto-generated constructor stub
		}

		

		public Product(Long id, String name, float price, String category, String description, String imageUrl) {
			super();
			this.id = id;
			this.name = name;
			this.price = price;
			this.category = category;
			this.description = description;
			this.imageUrl = imageUrl;
		}



		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public float getPrice() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}



		@Override
		public String toString() {
			return "Product [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category
					+ ", description=" + description + "]";
		}
		
		
}
