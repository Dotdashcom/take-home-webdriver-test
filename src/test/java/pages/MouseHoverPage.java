package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import base.BaseTest;

public class MouseHoverPage extends BaseTest {

	private By imgList = By.cssSelector("div[class='figure']");
	private By imgNameList = By.cssSelector(".figcaption > h5");
	private By viewProfileList = By.cssSelector(".figcaption > a");

	public void mouseHoverAndVerifyInfo() {
		List<WebElement> images = driver.findElements(imgList);
		List<WebElement> imgNames = driver.findElements(imgNameList);
		List<WebElement> viewProfiles = driver.findElements(viewProfileList);
		Actions action = new Actions(driver);
		for (int i = 0; i < images.size(); i++) {
			action.moveToElement(images.get(i)).perform();
			Assert.assertTrue(imgNames.get(i).isDisplayed());
			Assert.assertTrue(viewProfiles.get(i).isDisplayed());
		}
	}
}
