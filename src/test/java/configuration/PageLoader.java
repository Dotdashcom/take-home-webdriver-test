package configuration;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class PageLoader {

	/**
	 * Get the base url from config file and then load the
	 * specified page using the webdriver
	 * @param driver Webdriver instance
	 * @param page the page to load (e.g. /checkboxes)
	 */
	public static void loadPage(WebDriver driver, String page) {
		String baseurl = null;
		try {
			baseurl = PropertyReader.getPropertiesFromFile(
					"src/test/resources/config.properties",
					"baseurl");
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.get(baseurl + page);
	}
}
