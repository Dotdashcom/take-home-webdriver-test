package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckBoxesPage;

public class Test3_CheckBoxes extends CheckBoxesPage{
	
	Logger logger = LogManager.getLogger(Test3_CheckBoxes.class);

	String URL = prw.getProperties("baseURL");

	@BeforeMethod
	void openBrowser() {
		driver.get(URL + "/checkboxes");
		logger.info("The browser opened and navigated to " + URL + "/checkboxes");
	}

	@Test
	void checkUncheckCheckboxes() {
		checkBoxesAndAssert();
		uncheckBoxesAndAssert();
		logger.info("checkUncheckCheckboxes() Test successfully passed");
	}

}
