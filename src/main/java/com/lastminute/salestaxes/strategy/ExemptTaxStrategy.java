package com.lastminute.salestaxes.strategy;

import com.lastminute.salestaxes.model.ShoppingBasketItem;
import com.lastminute.salestaxes.util.Utils;

public class ExemptTaxStrategy implements TaxStrategy {

	@Override
	public void applyTaxes(ShoppingBasketItem shoppingBasketItem) {
		
		double totalPrice = shoppingBasketItem.getQuantity()
				* shoppingBasketItem.getProduct().getPrice();
		
		if (shoppingBasketItem.getProduct().isImported()) {
			double importDuty = shoppingBasketItem.getProduct().getPrice() * 0.05;
			shoppingBasketItem.setTotalPrice(totalPrice + Utils.roundTo005(importDuty));
			
		} else {
			shoppingBasketItem.setTotalPrice(totalPrice);
		}
	}


}
