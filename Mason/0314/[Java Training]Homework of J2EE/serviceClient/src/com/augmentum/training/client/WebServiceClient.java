package com.augmentum.training.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;

import com.augmentum.training.webserver.TemperatureConvertion;
import com.augmentum.training.webserver.TemperatureConvertionServiceLocator;

public class WebServiceClient {
	
	public static void main(String[] args) throws ServiceException, RemoteException {
		TemperatureConvertionServiceLocator tcl = 
							new TemperatureConvertionServiceLocator();
		TemperatureConvertion tc = tcl.getTemperatureConvertion();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		try {
			System.out.println("Please input the temperature end with 'f' or 'c'.");
			while ((s = br.readLine()) != null) {
				System.out.println(tc.convertTemperature(s));
				System.out.println("Please input again!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
