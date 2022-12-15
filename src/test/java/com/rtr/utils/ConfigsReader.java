package com.rtr.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.rtr.testbase.BaseClass;

public class ConfigsReader extends BaseClass {
	
	private static Properties prop;

	/**
	 * This method will read the properties file
	 * 
	 * @param String
	 */
	
	public static void readProperties(String filePath) {
		
		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param String key
	 * @return String value
	 */
	public static String getPropertyFromProp(String key) {
		return prop.getProperty(key);
	}
	
}
