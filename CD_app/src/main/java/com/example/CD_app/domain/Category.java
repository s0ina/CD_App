package com.example.CD_app.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long category_Id;
	private String category_name;
	
	public Long getCategory_Id() {
		return category_Id;
	}
	
	public void setCategory_Id(Long category_Id) {
		this.category_Id = category_Id;
	}
	
	public String getCategory_name() {
		return category_name;
	}
	
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	public Category(String category_name) {
		super();
		this.category_name = category_name;
	}
	
	public Category() {
		super();
		this.category_name = null;
	}
	
	@Override
	public String toString() {
		return "Category [category_Id=" + category_Id + ", category_name=" + category_name + "]";
	}
	
}
