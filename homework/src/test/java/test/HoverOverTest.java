package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.HoverOverPage;
import util.BrowserFactory;

public class HoverOverTest {

	WebDriver driver;

	@Test
	public void hoverOver() throws InterruptedException {

		driver = BrowserFactory.init();
		HoverOverPage hoverOverPage = PageFactory.initElements(driver, HoverOverPage.class);
		hoverOverPage.hoverOverMenu();

		hoverOverPage.hoverOver();

		// closing browser
		BrowserFactory.tearDown();

	}

}
