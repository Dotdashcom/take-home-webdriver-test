package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DropdownPage;

public class Test6_Dropdown extends DropdownPage{
	
	Logger logger = LogManager.getLogger(Test6_Dropdown.class);

	String URL = prw.getProperties("baseURL");

	@BeforeMethod
	void openBrowser() {
		driver.get(URL + "/dropdown");
		logger.info("The browser opened and navigated to " + URL + "/dropdown");
	}

	@Test
	void dropdownAction() {
		dropdown();
		logger.info("dropdownAction() Test successfully passed");
	}

}
