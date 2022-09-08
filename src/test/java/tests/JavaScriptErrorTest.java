package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.JavaScriptErrorPage;
import util.BrowserFactory;

public class JavaScriptErrorTest extends BrowserFactory {
	static JavaScriptErrorPage javaScriptErrorPage;

	@BeforeMethod
	public static void beforeTests() {
		init("javascript_error");
		javaScriptErrorPage = PageFactory.initElements(driver, JavaScriptErrorPage.class);
	}

	@Test(priority = 1)
	public static void testFindsTheJavaScriptErrorOnThePageAndValidateCannotReadPropertyXYZOfUndefinedErrorIsPresent() {
//		Open declaration of method below for commits of code 
		javaScriptErrorPage.findingJavaScriptError();
		
//		Unable to validate because I could not simply figure out the first one.
		javaScriptErrorPage.validatesErrorCannotReadPropertyIsPresent();
	}

	@AfterMethod
	public static void afterTests() {
		tearDown();
	}

}
