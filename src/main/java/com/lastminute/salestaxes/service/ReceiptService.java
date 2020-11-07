package com.lastminute.salestaxes.service;

import com.lastminute.salestaxes.model.ShoppingBasket;
import com.lastminute.salestaxes.strategy.BasicSalesTaxStrategy;
import com.lastminute.salestaxes.strategy.ExemptTaxStrategy;
import com.lastminute.salestaxes.strategy.TaxStrategy;

public class ReceiptService {
	
	public String getReceipt(ShoppingBasket shoppingBasket) {

		shoppingBasket.getItems().stream().forEach(item -> {

			TaxStrategy taxStrategy;

			switch (item.getProduct().getCategory()) {
			case Book:
				taxStrategy = new ExemptTaxStrategy();
				break;
			case Food:
				taxStrategy = new ExemptTaxStrategy();
				break;
			case Medical:
				taxStrategy = new ExemptTaxStrategy();
				break;
			case Other:
				taxStrategy = new BasicSalesTaxStrategy();
				break;
			default:
				taxStrategy = new BasicSalesTaxStrategy();
				break;
			}
			
			taxStrategy.applyTaxes(item);
		});
		
		System.out.println(shoppingBasket.toString());
		
		return shoppingBasket.toString();
	}

}
