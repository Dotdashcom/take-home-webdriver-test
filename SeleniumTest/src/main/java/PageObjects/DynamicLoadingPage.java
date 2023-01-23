package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.AbstractClass;

public class DynamicLoadingPage extends AbstractClass {
	WebDriver driver;

	public DynamicLoadingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "finish")
	WebElement textdisplay;

	@FindBy(css = "div[id='start'] button")
	WebElement startbutton;

	By waittext = By.id("finish");

	public String displaytext() {
		startbutton.click();
		waitforElementToAppear(waittext);
		String displayedtextmessage = textdisplay.getText();
		return displayedtextmessage;
	}

}
