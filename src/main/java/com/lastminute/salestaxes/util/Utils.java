package com.lastminute.salestaxes.util;

public class Utils {
	
	public static double roundTo005(double number) {
		
		double hundreds = number * 100;
		double rest = hundreds % 5;
		
		if (rest == 0) {
			return hundreds / 100;
			
		} else {
			return (hundreds + 5 - rest) / 100;
		}
	}
	
}
