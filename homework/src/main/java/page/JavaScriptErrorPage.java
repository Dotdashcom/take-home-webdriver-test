package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class JavaScriptErrorPage {

	WebDriver driver;

	public JavaScriptErrorPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'JavaScript onload event error')]")
	WebElement JAVASCRIPTERROR_MENU_ELEMENT;

	public void javaScriptErrorMenu() {
		JAVASCRIPTERROR_MENU_ELEMENT.click();
	}

	public void assertJavaScriptError() {

		String actualResult = "Page with JavaScript errors on load";
		String expectedResult = driver.getTitle();
		System.out.println(actualResult);
		System.out.println(expectedResult);
		Assert.assertEquals(actualResult, expectedResult);

	}

}
