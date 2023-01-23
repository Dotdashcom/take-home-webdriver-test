package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.AbstractClass;

public class FramesPage extends AbstractClass {
	WebDriver driver;

	@FindBy(css = "a[href='/iframe']")
	WebElement iframe;

	public FramesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public IframePage nextframe() throws InterruptedException {
		iframe.click();
		Thread.sleep(5000);
		IframePage iframePage = new IframePage(driver);
		return iframePage;
	}

}
