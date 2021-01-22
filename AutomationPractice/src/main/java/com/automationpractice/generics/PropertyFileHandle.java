package com.automationpractice.generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileHandle {
	static String propertyPath = "../AutomationPractice/Properties/Practice.properties";

	// To get the property from the property file
	public static String getpropertyvalue(String key) {

		Properties property = new Properties();

		try {
			property.load(new FileInputStream(PropertyFileHandle.propertyPath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return property.getProperty(key);

	}

}
