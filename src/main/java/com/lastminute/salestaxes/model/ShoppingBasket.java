package com.lastminute.salestaxes.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.DoubleStream;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ShoppingBasket {

	List<ShoppingBasketItem> items;
	
	
	public boolean add(ShoppingBasketItem item) {
		if (items == null) {
			items = new ArrayList<>();
		}
		return items.add(item);
	}
	
	/**
	 * @return the sum of the total price of all items
	 */
	public double getTotal() {
		return items.stream().flatMapToDouble(item -> DoubleStream.of(item.getTotalPrice())).sum();
	}
	
	/**
	 * @return the sum of the sales taxes applied
	 */
	public double getSalesTaxes() {
		return getTotal() - 
				items.stream().flatMapToDouble(item -> DoubleStream.of(item.getProduct().getPrice())).sum();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		items.stream().forEach(item -> sb.append(item.toString()).append("\n"));
		
		sb.append("Sales Taxes: ")
		.append(String.format(Locale.ENGLISH, "%.2f", getSalesTaxes()))
		.append("\nTotal: ")
		.append(String.format(Locale.ENGLISH, "%.2f", getTotal()));

		return sb.toString();
	}

}
