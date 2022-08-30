package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DragAndDropPage;
import page.DropDownPage;
import util.BrowserFactory;

public class DropDownTest {

	WebDriver driver;

	@Test
	public void dropDown() throws InterruptedException {

		driver = BrowserFactory.init();

		DropDownPage dropDownPage = PageFactory.initElements(driver, DropDownPage.class);
		dropDownPage.dropDownMenu();
		dropDownPage.dropDown();

		// closing browser
		BrowserFactory.tearDown();

	}

}
