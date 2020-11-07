package com.lastminute.salestaxes.strategy;

import com.lastminute.salestaxes.model.ShoppingBasketItem;

public interface TaxStrategy {

	
	public void applyTaxes(ShoppingBasketItem shoppingBasketItem);

}
