package com.dotdash.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import com.dotdash.page.AbstractPage;
import com.dotdash.util.Settings;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractWebDriverTest {

	@BeforeSuite
	public static void setUpSuite() {
		WebDriverManager.chromedriver().setup();
	}
	
	/**
	 * Using reflection to get path of a page and navigate to it. 
	 */
	@SuppressWarnings("unchecked")
	protected <T> T navigateTo(WebDriver driver, Class<? extends AbstractPage> pageModel) {
		try {
			String path = (String) pageModel.getDeclaredField("RELATIVE_PATH").get(null);
			driver.get(Settings.getBaseUrl() + path);
			Constructor<T> constructor = (Constructor<T>) pageModel.getConstructor(WebDriver.class);
			return constructor.newInstance(driver);
		} catch (
				NoSuchMethodException|
				SecurityException|
				InstantiationException|
				IllegalAccessException|
				IllegalArgumentException|
				InvocationTargetException|
				NoSuchFieldException e) {
			e.printStackTrace(); 
		}
		return null;
	}
}
