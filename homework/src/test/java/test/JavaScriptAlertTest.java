package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.JavaScriptAlertPage;
import util.BrowserFactory;

public class JavaScriptAlertTest {

	WebDriver driver;

	@Test
	public void javaScriptAlertCheck() throws InterruptedException {

		driver = BrowserFactory.init();

		JavaScriptAlertPage javaScriptPage = PageFactory.initElements(driver, JavaScriptAlertPage.class);
		javaScriptPage.javaScriptAlertMenu();

		javaScriptPage.javaAlertElement();
		javaScriptPage.javaConfirmElement();
		javaScriptPage.javaPromptElement();

		// closing browser
		BrowserFactory.tearDown();

	}

}
