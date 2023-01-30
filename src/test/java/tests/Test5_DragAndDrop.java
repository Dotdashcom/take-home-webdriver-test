package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DragAndDropPage;

public class Test5_DragAndDrop extends DragAndDropPage{
	
	Logger logger = LogManager.getLogger(Test5_DragAndDrop.class);

	String URL = prw.getProperties("baseURL");

	@BeforeMethod
	void openBrowser() {
		driver.get(URL + "/drag_and_drop");
		logger.info("The browser opened and navigated to " + URL + "/drag_and_drop");
	}

	@Test
	void dragAndDropAction() {
		dragAndDrop();
		assertDragged();
		logger.info("contextMenuVerification() Test successfully passed");
	}

}
