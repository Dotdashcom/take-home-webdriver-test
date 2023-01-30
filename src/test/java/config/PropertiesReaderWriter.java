package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesReaderWriter {

	Properties prop = new Properties();
	String path = System.getProperty("user.dir");

	public String getProperties(String name) {
		try {
			InputStream input = new FileInputStream(path + "/src/test/java/config/config.properties");
			prop.load(input);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return prop.getProperty(name);
	}

	public void setProperties(String name, String value) {
		try {
			OutputStream output = new FileOutputStream(path + "/src/test/java/config/config.properties");
			prop.setProperty(name, value);
			output.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	
	}

}
