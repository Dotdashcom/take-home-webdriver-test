package com.dotDash.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.dotDash.base.Constants;

/**
 * The Class has all TestProperties (All properties mentioned in
 * <strong>UserTestDefault.properties</strong> file).
 *
 * @author Seb Geb
 */
public class TestProperties {

	/** The Constant props. */
	private static final Properties props = new Properties();

	/**
	 * @author Seb Geb Load all propertie.
	 */
	public static void loadAllPropertie() {
		try {
			FileInputStream Locator;
			Locator = new FileInputStream(Constants.PROPERTY_FILE_PATH);
			props.load(Locator);
		} catch (IOException e) {
			LoggerUtil.getLogger().fatal("Could not load properties : " + e.getMessage());
		}
	}

	/**
	 * Gets the property.
	 * 
	 * @author Seb Geb
	 * @param key the key
	 * @return the property
	 */
	public static String getProperty(String key) {
		return props.getProperty(key);
	}

	/**
	 * Put property.
	 * 
	 * @author Seb Geb
	 * @param key   the key
	 * @param value the value
	 */
	public static void putProperty(String key, String value) {
		props.put(key, value);
	}
}
