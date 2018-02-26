package com.applicationStart;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity // Tells Spring to use this as our model
public class MenuItem {
	
	@Id // Specifies primary key
	@GeneratedValue(strategy = GenerationType.SEQUENCE) // Produce key sequentially; 1, 2, 3 ... n
	private long Id;
	
	private String name;
	private double price;
	private String description;
	private boolean containsNuts;
	private boolean isVeg;
	private String calories;
	private int prepTime;
	
	public MenuItem() {} // MenuSeeder needs an empty constructor for entities to work
	
	public MenuItem(String name, double price, String description, boolean containsNuts, boolean isVeg, String calories, int prepTime) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.containsNuts = containsNuts;
		this.isVeg = isVeg;
		this.calories = calories;
		this.prepTime = prepTime;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isContainsNuts() {
		return containsNuts;
	}

	public void setContainsNuts(boolean containsNuts) {
		this.containsNuts = containsNuts;
	}

	public boolean isVeg() {
		return isVeg;
	}

	public void setVeg(boolean isVeg) {
		this.isVeg = isVeg;
	}

	public String getCalories() {
		return calories;
	}

	public void setCalories(String calories) {
		this.calories = calories;
	}
	
	public int getPrepTime() {
		return prepTime;
	}
	
	public void setPrepTime(int prepTime) {
		this.prepTime = prepTime;
	}


}
