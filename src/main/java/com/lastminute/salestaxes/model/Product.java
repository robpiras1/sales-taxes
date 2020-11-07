package com.lastminute.salestaxes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class Product {
	
	private String name;
	private ProductCategory category;
	private boolean imported;
	private double price;

}
