package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FloatingMenuPage;

public class Test12_FloatingMenu extends FloatingMenuPage{
	
	Logger logger = LogManager.getLogger(Test12_FloatingMenu.class);

	String URL = prw.getProperties("baseURL");

	@BeforeMethod
	void openBrowser() {
		driver.get(URL + "/floating_menu");
		logger.info("The browser opened and navigated to " + URL + "/floating_menu");
	}

	@Test
	void floatingMenu_() {
		floatingMenuDuringScroll();
		logger.info("floatingMenu_() Test successfully passed");
	}

}
