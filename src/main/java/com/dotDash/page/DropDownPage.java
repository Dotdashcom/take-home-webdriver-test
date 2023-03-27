package com.dotDash.page;

import com.dotDash.page.common.BasePage;
import com.dotDash.utils.TestProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * This Class is have Login Screen related Locators and respective methods
 * 
 * @author Seb Geb
 *
 */
public class DropDownPage extends BasePage {
	private WebDriver driver;

	public DropDownPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//h3[text()='Dropdown List']")
	private WebElement dropDownHeader;
	@FindBy(css = "#dropdown")
	private WebElement dropDown;
	/**
	 * To check DropDown page
	 *
	 * @author Seb Geb
	 *
	 */
	public void navigateToDropDownPage() {
		navigateTo(TestProperties.getProperty("DROPDOWN_URL"));
		Assert.assertEquals(checkWebElementExist(dropDownHeader), true);
	}
	/**
	 * To Validate Checkboxes functionality
	 * @author Seb Geb
	 *
	 */
	
	public void validateDropDownFeature() {
		selectDropDown(dropDown,"Option 1");
		Assert.assertEquals(getWebElementAttribute(dropDown.findElement(By.xpath("./option[text()='Option 1']")),"selected"), "true");
		Assert.assertEquals(getWebElementAttribute(dropDown.findElement(By.xpath("./option[text()='Option 2']")),"selected"), null);
		selectDropDown(dropDown,"Option 2");
		Assert.assertEquals(getWebElementAttribute(dropDown.findElement(By.xpath("./option[text()='Option 2']")),"selected"), "true");
		Assert.assertEquals(getWebElementAttribute(dropDown.findElement(By.xpath("./option[text()='Option 1']")),"selected"), null);
	}
}
