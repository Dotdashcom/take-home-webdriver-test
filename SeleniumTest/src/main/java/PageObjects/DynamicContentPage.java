package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.AbstractClass;

public class DynamicContentPage extends AbstractClass {
	WebDriver driver;

	public DynamicContentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(partialLinkText = "click here")
	WebElement refreshLink;
	@FindBy(css = ".large-10.columns.large-centered")
	WebElement content;

	public boolean refreshPage() {

		refreshLink.click();
		String result = content.getText();

		refreshLink.click();
		String result1 = content.getText();

		refreshLink.click();
		String result2 = content.getText();

		if (result.equals(result1) && result.equals(result2) && result1.equals(result2)) {
			return true;
		} else {
			return false;
		}
	}

}
