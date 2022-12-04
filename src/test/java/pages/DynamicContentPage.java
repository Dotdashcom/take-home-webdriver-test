package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseTest.AbstractE2E;

public class DynamicContentPage {

	WebDriver driver;

	public DynamicContentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Elements or locators
	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[1]/div[1]")
	WebElement content;

	public String getCurrentContent() {
		return content.getAttribute("innerHTML");
	}

	// get url
	public DynamicContentPage getUrl() {
		driver.navigate().to(AbstractE2E.url + "/dynamic_content");
		return this;
	}
}
