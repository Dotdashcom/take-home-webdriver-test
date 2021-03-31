package com.webdrivertest.base;

import java.util.Properties;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
/**
 * 
 * @author iturkmen
 *
 */
public class OptionsManager {
	
	public ChromeOptions co;
	public FirefoxOptions fo;
	public Properties prop;
	/**
	 * OptionsManager
	 * @author iturkmen
	 * @param prop
	 */
	public OptionsManager(Properties prop) {
		this.prop = prop;
	}
	/**
	 * ChromeOptions
	 * @author iturkmen
	 * @return
	 */
	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		if(prop.getProperty("incognito").equals("yes")) co.addArguments("--incognito");
		if(prop.getProperty("headless").equals("yes")) co.addArguments("--headless");
		return co;
	}
	/**
	 * FirefoxOptions
	 * @author iturkmen
	 * @return
	 */
	public FirefoxOptions getFirefoxOptions() {
		fo = new FirefoxOptions();
		if(prop.getProperty("headless").equals("yes")) fo.addArguments("--headless");
		return fo;
	}

}
