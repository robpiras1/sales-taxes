package com.lastminute.salestaxes.model;

import java.util.Locale;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ShoppingBasketItem {
	
	private long quantity;
	private Product product;
	private double totalPrice;
	
	public ShoppingBasketItem(long quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append(quantity)
				.append(product.isImported() ? " imported " : " ")
				.append(product.getName())
				.append(": ")
				.append(String.format(Locale.ENGLISH, "%.2f", totalPrice))
				.toString();
	}
}
