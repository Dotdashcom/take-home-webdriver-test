package com.library.pitias;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.testng.log4testng.Logger;

public class PropertiesManager {
final static Logger logger = Logger.getLogger(PropertiesManager.class);
	
	private Properties prop;
	private String filePath;
	private FileInputStream input;
	private FileOutputStream output;
	private String value;
	
	
	
	public PropertiesManager(String filePAth) {
		this.filePath=filePAth;
		prop = new Properties();
	}
	
	public String readProperties(String key) {
		try {
			input = new FileInputStream(filePath);
			prop.load(input);
		    value =prop.getProperty(key);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		} finally{
			try {
				input.close();
			}catch(Exception e) {
				assertTrue(false);
			}
		}
		return value;
		
	}
	public void setProperties(String key,String value) {
	try{  
		output = new FileOutputStream(filePath);
		prop.setProperty(key, value);
		prop.store(output, "the browser is set to "+value);
		
	} catch (Exception e) {
		logger.info(e.getMessage());
		e.printStackTrace();
	} finally{
		try {
			output.close();
		}catch(Exception e) {
			assertTrue(false);
		}
	}

	
	
	
	}
}
