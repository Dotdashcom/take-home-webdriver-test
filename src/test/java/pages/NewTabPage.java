package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;

import base.BaseTest;

public class NewTabPage extends BaseTest {

	private By clickHereLink = By.linkText("Click Here");
	private By resultText = By.cssSelector(".example > h3");

	public void clickLinkTextAndNavigateToNewTab() {

		String currentHandle = driver.getWindowHandle();
		driver.findElement(clickHereLink).click();
		Set<String> handles = driver.getWindowHandles();

		for (String actual : handles) {
			if (!actual.equalsIgnoreCase(currentHandle)) {
				driver.switchTo().window(actual);
			}
		}
		Assert.assertTrue(driver.findElement(resultText).getText().equals("New Window"));
	}

}
