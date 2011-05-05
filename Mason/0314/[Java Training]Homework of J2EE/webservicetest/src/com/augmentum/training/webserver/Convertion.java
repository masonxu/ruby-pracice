package com.augmentum.training.webserver;


public class Convertion {
	
	public double centigradeToFahrenheit(double f) {
		return  1.8 * f + 32;
	}
	
	public double fahrenheitToCentigrade(double f) {
		return   (f -32) / 1.8 ;
	}
}

