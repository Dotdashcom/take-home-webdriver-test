package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.IframePage;
import util.BrowserFactory;

public class IframeTest {

	WebDriver driver;

	@Test
	public void iframeCheck() {

		driver = BrowserFactory.init();

		IframePage iframePage = PageFactory.initElements(driver, IframePage.class);
		iframePage.frameMenu();
		iframePage.iframeElement();

		// closing browser
		BrowserFactory.tearDown();

	}

}
