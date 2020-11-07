package com.lastminute.salestaxes.strategy;

import com.lastminute.salestaxes.model.ShoppingBasketItem;
import com.lastminute.salestaxes.util.Utils;

public class BasicSalesTaxStrategy implements TaxStrategy {

	@Override
	public void applyTaxes(ShoppingBasketItem shoppingBasketItem) {
		
		double salesTax;
		
		if (shoppingBasketItem.getProduct().isImported()) {
			salesTax = shoppingBasketItem.getProduct().getPrice() * 0.15;
		} else {
			salesTax = shoppingBasketItem.getProduct().getPrice() * 0.10;
		}

		double totalPrice = shoppingBasketItem.getQuantity()
				* (shoppingBasketItem.getProduct().getPrice() + Utils.roundTo005(salesTax));
		
		shoppingBasketItem.setTotalPrice(totalPrice);
	}

}
