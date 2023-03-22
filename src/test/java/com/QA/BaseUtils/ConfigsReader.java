package com.QA.BaseUtils;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {

	public static Properties prop, prop1;

	/**
	 * This method will read properties file
	 * 
	 * @param filePath
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
	 * This method will store data in key/value format to properties file
	 * 
	 * @param filePath
	 * @param key
	 * @param value
	 */
	public static void storeDataToProperties(String filePath, String key, String value) {
		try {
			FileOutputStream fos = new FileOutputStream(filePath, true);
			prop1 = new Properties();
			prop1.setProperty(key, value);
			prop1.store(fos, null);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will store data to TXT file
	 * 
	 * @param filePath
	 * @param value
	 */
	public static void storeDataToFile(String filePath, String value) {
		try {
			BufferedWriter output = new BufferedWriter(new FileWriter(filePath, true));
			output.newLine();
			output.append(value);
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will return value of specified key
	 * 
	 * @param String key
	 * @return String value
	 */
	public static String getProperty(String key) {

		return prop.getProperty(key);
	}

	/**
	 * This method will read properties file and get a properties by key
	 * 
	 * @param key
	 * @param filePath
	 */
	public static String readAndGetProperty(String filePath, String key) {
		readProperties(filePath);
		return getProperty(key);
	}

}
