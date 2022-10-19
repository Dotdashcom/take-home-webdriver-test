package pagepackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseTest;

public class JSError extends BaseTest {

	public JSError() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="/html/body")
	private static WebElement error;
	
	public void Error() {
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 String er = js.executeScript("return document.body;").toString();
		error.getAttribute("body");
		System.out.println(er);
	}
}
