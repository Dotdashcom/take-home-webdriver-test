package com.dotDash.page.common;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;

import com.dotDash.base.WebDriverContext;

/**
 * A factory for creating Pageinstances objects.
 * 
 * @author Seb Geb
 */
public class PageinstancesFactory {

	/**
	 * Gets the single instance of PageinstancesFactory.
	 * 
	 * @author Seb Geb
	 * @param <T>  the generic type
	 * @param type the type
	 * @return single instance of PageinstancesFactory
	 */
	public static <T extends BasePage> T getInstance(Class<T> type) {
		try {
			return type.getConstructor(WebDriver.class).newInstance(WebDriverContext.getDriver());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}
}
