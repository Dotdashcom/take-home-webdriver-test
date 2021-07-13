package com.selenium.test.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Assert;

public class CommonUtil {
	
	public static Properties getPropFileByPath(String filePath) {

		Properties prop = new Properties();
		InputStream is = null;

		try {

			/** load properties file **/

			File file = new File(filePath);

			is = new FileInputStream(file);
			prop.load(is);
			is.close();

		} catch (Exception e) {

			String alertString = String.format("\n* Alert: failed to retrieve properties file from '%s'..\n\n", filePath);
			Assert.assertTrue(alertString,false);
		}

		return prop;
	}

}
