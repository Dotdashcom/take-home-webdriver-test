package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContextMenuPage;

public class Test4_ContextMenu extends ContextMenuPage{
	
	Logger logger = LogManager.getLogger(Test4_ContextMenu.class);

	String URL = prw.getProperties("baseURL");

	@BeforeMethod
	void openBrowser() {
		driver.get(URL + "/context_menu");
		logger.info("The browser opened and navigated to " + URL + "/context_menu");
	}

	@Test
	void contextMenuVerification() {
		clickTheBoxAndAssertAlert("You selected a context menu");
		logger.info("contextMenuVerification() Test successfully passed");
	}

}
