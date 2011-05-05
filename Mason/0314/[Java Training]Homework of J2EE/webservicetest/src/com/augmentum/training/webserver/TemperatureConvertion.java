package com.augmentum.training.webserver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemperatureConvertion {
	
	public TemperatureConvertion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String convertTemperature(String s) {
		String[] temp;
		String number;
		double d;
		Pattern p = Pattern.compile("\\D");
		Matcher m ;
		
		
		if (s.endsWith("f")) {
			//if f indicates Fahrenheit then convert into Centigrade.
			temp = s.split("f");
			number = temp[0];
			m = p.matcher(number);
			if (m.find()) {
				System.out.println("Sorry, the input is illegal!");
			} else {
				d = Double.parseDouble(number);
				double d2 = (d - 32) / 1.8;
				return String.valueOf(d2) + "c";
			}
		} else if (s.endsWith("c")) {
			//if f indicates Centigrade then convert into Fahrenheit.
			temp = s.split("c");
			number = temp[0];
			temp = s.split("f");
			number = temp[0];
			m = p.matcher(number);		
			if (m.find()) {
				System.out.println("Sorry, the input is illegal!");
			} else {
				d = Double.parseDouble(number);
				double d2 = 1.8 * d + 32;
				return String.valueOf(d2) + "f";
			}
		} 
		
		return "sorry, the input is illegal";
		
	}
}

