package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class CheckBoxesPage {

	WebDriver driver;

	public CheckBoxesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Elements or locators
	@FindBy(xpath = "//*[@id='checkboxes']/input[@type='checkbox'][1]")
	WebElement checkbox1;

	@FindBy(xpath = "//*[@id='checkboxes']/input[@type='checkbox'][2]")
	WebElement checkbox2;

	public WebElement getCheckBox1() {
		return checkbox1;
	}

	public WebElement getCheckBox2() {
		return checkbox2;
	}

	// get url
	public CheckBoxesPage getUrl() {
		driver.navigate().to(TestBase.url + "/checkboxes");
		return this;
	}
}
