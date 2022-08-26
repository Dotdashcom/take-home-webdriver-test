package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.CheckAndUncheckBoxesPage;
import util.BrowserFactory;

public class CheckAndUncheckBoxesTest {

	WebDriver driver;

	@Test
	public void checkAndUncheckBoxes() throws InterruptedException {

		driver = BrowserFactory.init();

		CheckAndUncheckBoxesPage checkAndUncheckPage = PageFactory.initElements(driver, CheckAndUncheckBoxesPage.class);
		checkAndUncheckPage.clickCheckBox();
		checkAndUncheckPage.checkBoxSelect();
		
		//closing browser
		BrowserFactory.tearDown();

	}

}
