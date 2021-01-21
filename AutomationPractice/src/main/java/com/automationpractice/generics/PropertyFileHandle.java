package com.automationpractice.generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class PropertyFileHandle 
{
	static String propertypath="../AutomationPractice/Properties/Practice.properties";
	//To get the property from the property file 
	public static String getpropertyvalue(String key)
	{
		
	
	Properties property=new Properties();
	
		try {
			property.load(new FileInputStream(PropertyFileHandle.propertypath));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	 
	
	return property.getProperty(key);
	
}
	
}
