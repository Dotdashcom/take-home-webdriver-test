package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath = "src//test//resources//applicationsConfig.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}
	public String getBaseUrl(){
		String baseUrl = properties.getProperty("baseUrl");
		if(baseUrl!= null) return baseUrl;
		else throw new RuntimeException("baseUrl not specified in the applicationsConfig.properties file.");		
	}
	
	public String getValidUsername() {		
		String validUsername = properties.getProperty("validUsername");
		if(validUsername != null) return validUsername;
		else throw new RuntimeException("validUsername not specified in the applicationsConfig.properties file.");		
	}
	
	public String getValidPassword() {		
		String validPassword = properties.getProperty("validPassword");
		if(validPassword != null) return validPassword;
		else throw new RuntimeException("validPassword not specified in the applicationsConfig.properties file.");		
	}
	
	public String getInvalidUsername() {		
		String invalidUsername = properties.getProperty("invalidUsername");
		if(invalidUsername != null) return invalidUsername;
		else throw new RuntimeException("invalidUsername not specified in the applicationsConfig.properties file.");		
	}
	
	public String getInvalidPassword() {		
		String invalidPassword = properties.getProperty("invalidPassword");
		if(invalidPassword != null) return invalidPassword;
		else throw new RuntimeException("invalidPassword not specified in the applicationsConfig.properties file.");		
	}
	
	public String getContextMenuText() {		
		String contextMenuText = properties.getProperty("contextMenuText");
		if(contextMenuText != null) return contextMenuText;
		else throw new RuntimeException("contextMenuText not specified in the applicationsConfig.properties file.");		
	}
	
	public String getDynamicLoadingText() {		
		String dynamicLoadingText = properties.getProperty("dynamicLoadingText");
		if(dynamicLoadingText != null) return dynamicLoadingText;
		else throw new RuntimeException("dynamicLoadingText not specified in the applicationsConfig.properties file.");		
	}
}
