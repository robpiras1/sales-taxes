package com.lastminute.salestaxes.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.lastminute.salestaxes.model.Product;
import com.lastminute.salestaxes.model.ProductCategory;
import com.lastminute.salestaxes.model.ShoppingBasket;
import com.lastminute.salestaxes.model.ShoppingBasketItem;

public class ReceiptServiceTest {

	private static ReceiptService receiptService;

	@BeforeAll
	public static void beforeAll() {
		receiptService = new ReceiptService();
	}

	@Test
	public void getReceipt_input1() throws IOException {
		/* Input 1:
		1 book at 12.49
		1 music CD at 14.99
		1 chocolate bar at 0.85 */

		Product book = new Product("book", ProductCategory.Book, false, 12.49);
		Product musicCD = new Product("music CD", ProductCategory.Other, false, 14.99);
		Product chocolateBar = new Product("chocolate bar", ProductCategory.Food, false, 0.85);

		ShoppingBasket shoppingBasket = new ShoppingBasket();
		shoppingBasket.add(new ShoppingBasketItem(1, book));
		shoppingBasket.add(new ShoppingBasketItem(1, musicCD));
		shoppingBasket.add(new ShoppingBasketItem(1, chocolateBar));

		System.out.println("\nOutput 1:");
		
		String receipt = receiptService.getReceipt(shoppingBasket);

		assertEquals("1 book: 12.49"
				+ "\n1 music CD: 16.49"
				+ "\n1 chocolate bar: 0.85"
				+ "\nSales Taxes: 1.50"
				+ "\nTotal: 29.83", receipt);
	}

	@Test
	public void getReceipt_input2() throws IOException {
		/* Input 2:
		1 imported box of chocolates at 10.00
		1 imported bottle of perfume at 47.50 */

		Product boxOfChocolates = new Product("box of chocolates", ProductCategory.Food, true, 10.00);
		Product bottleOfPerfume = new Product("bottle of perfume", ProductCategory.Other, true, 47.50);

		ShoppingBasket shoppingBasket = new ShoppingBasket();
		shoppingBasket.add(new ShoppingBasketItem(1, boxOfChocolates));
		shoppingBasket.add(new ShoppingBasketItem(1, bottleOfPerfume));

		System.out.println("\nOutput 2:");
		
		String receipt = receiptService.getReceipt(shoppingBasket);

		assertEquals("1 imported box of chocolates: 10.50"
				+ "\n1 imported bottle of perfume: 54.65"
				+ "\nSales Taxes: 7.65"
				+ "\nTotal: 65.15", receipt);
	}

	@Test
	public void getReceipt_input3() throws IOException {
		/* Input 3:
		1 imported bottle of perfume at 27.99
		1 bottle of perfume at 18.99
		1 packet of headache pills at 9.75
		1 imported box of chocolates at 11.25 */

		Product importedBottleOfPerfume = new Product("bottle of perfume", ProductCategory.Other, true, 27.99);
		Product bottleOfPerfume = new Product("bottle of perfume", ProductCategory.Other, false, 18.99);
		Product packetOfHeadachePills = new Product("packet of headache pills", ProductCategory.Medical, false, 9.75);
		Product boxOfImportedChocolates = new Product("box of chocolates", ProductCategory.Medical, true, 11.25);

		ShoppingBasket shoppingBasket = new ShoppingBasket();
		shoppingBasket.add(new ShoppingBasketItem(1, importedBottleOfPerfume));
		shoppingBasket.add(new ShoppingBasketItem(1, bottleOfPerfume));
		shoppingBasket.add(new ShoppingBasketItem(1, packetOfHeadachePills));
		shoppingBasket.add(new ShoppingBasketItem(1, boxOfImportedChocolates));

		System.out.println("\nOutput 3:");
		
		String receipt = receiptService.getReceipt(shoppingBasket);

		assertEquals("1 imported bottle of perfume: 32.19"
				+ "\n1 bottle of perfume: 20.89"
				+ "\n1 packet of headache pills: 9.75"
				+ "\n1 imported box of chocolates: 11.85"
				+ "\nSales Taxes: 6.70"
				+ "\nTotal: 74.68", receipt);
	}

}
