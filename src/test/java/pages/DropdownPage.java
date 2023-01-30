package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.BaseTest;

public class DropdownPage extends BaseTest {

	private By dropdown = By.id("dropdown");
	private By selected = By.cssSelector("option[selected='selected']");

	public void dropdown() {
		Select drp = new Select(driver.findElement(dropdown));
		drp.selectByValue("1");
		Assert.assertEquals(driver.findElement(selected).getText(), "Option 1");
		drp.selectByValue("2");
		Assert.assertEquals(driver.findElement(selected).getText(), "Option 2");
	}

}
