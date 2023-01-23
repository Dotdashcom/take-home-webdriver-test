package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Random;

public class Base_Page {
	public int x = RAND(999);

	public int RAND(int i) {
		Random rnd = new Random();
		int dom = rnd.nextInt(i);
		return dom;
	}
	public void SELECT(WebElement Welement, String visibiletext) {
		Select sel = new Select(Welement);
		sel.selectByVisibleText(visibiletext);
	}
	//wait methods
	public void WaitFor_visibility(WebDriver driver, Duration TimeBySecond, WebElement ElementName) {
		WebDriverWait wait = new WebDriverWait(driver, TimeBySecond);
		wait.until(ExpectedConditions.visibilityOf(ElementName));
	}


	public void WaitFor_present(WebDriver driver, Duration TimeBySecond, WebElement ElementName,String to_be_present) {
		WebDriverWait wait = new WebDriverWait(driver, TimeBySecond);
		wait.until(ExpectedConditions.textToBePresentInElement(ElementName, to_be_present));
	}

	public void WaitFor_state(WebDriver driver, Duration TimeBySecond, WebElement ElementName, boolean status) {
		WebDriverWait wait = new WebDriverWait(driver, TimeBySecond);
		wait.until(ExpectedConditions.elementSelectionStateToBe(ElementName, status));

	}
	public void WaitFor_attribute_To_Be_Not_Empty(WebDriver driver, Duration TimeBySecond, WebElement ElementName, String attribute_state) {
		WebDriverWait wait = new WebDriverWait(driver, TimeBySecond );
		wait.until(ExpectedConditions.attributeToBeNotEmpty(ElementName, attribute_state));



	}


	//assertion methods
	public void check_String(String actual, String expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}
	public void check_boolean(boolean actual, boolean expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}
	public void check_List(Object actual, Object expected, String message) {
		Assert.assertEquals(actual, expected, message);

	}
}
