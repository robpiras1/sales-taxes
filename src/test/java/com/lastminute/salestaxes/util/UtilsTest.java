package com.lastminute.salestaxes.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UtilsTest {
	
	@Test
	public void roundTo005() {
		double number = 1.53;
		double result = Utils.roundTo005(number);
		
		assertEquals(1.55, result);
	}
	
	
	@Test
	public void roundTo005_noRound() {
		double number = 1.55;
		double result = Utils.roundTo005(number);
		
		assertEquals(1.55, result);
	}
	
}
