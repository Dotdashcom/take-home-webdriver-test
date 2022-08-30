package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.JavaScriptErrorPage;
import util.BrowserFactory;

public class JavaScriptErrorTest {

	WebDriver driver;

	@Test
	public void javaScriptErrorCheck() throws InterruptedException {

		driver = BrowserFactory.init();

		JavaScriptErrorPage javaScriptErrorPage = PageFactory.initElements(driver, JavaScriptErrorPage.class);
		javaScriptErrorPage.javaScriptErrorMenu();
		javaScriptErrorPage.assertJavaScriptError();

		// closing browser
		BrowserFactory.tearDown();

	}

}
