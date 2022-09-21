package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {
	
	public static Properties property;
	
	/**
	 * This method will read the properties file from configuration.properties file
	 * 
	 * @param filepath
	 */

	public static void readProperties(String filepath) {
		
		try {
			
			FileInputStream fileInput = new FileInputStream(filepath);
			property = new Properties();
			property.load(fileInput);
			fileInput.close();					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception ec) {
			ec.printStackTrace();
		}
		
	}
	
	/**
	 * This method will return the value for a specific key
	 * 
	 * @param String key
	 * @return String value
	 */
	public static String getProperty(String key) {
		return property.getProperty(key);
	}
	
	
	
	
}
