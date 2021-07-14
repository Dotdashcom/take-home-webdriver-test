package com.theInternetUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigProvider {
	
	public static Properties prop;
	
	public static void loadProperties() {
		File file = new File("./config/config.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Unable to find config file " + e.getMessage());
		}
	}

	public static String getConfigProp(String key) {
		return prop.getProperty(key);
	}

}
