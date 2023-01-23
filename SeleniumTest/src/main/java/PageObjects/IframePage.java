package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractClass;

public class IframePage extends AbstractClass {
	WebDriver driver;

	@FindBy(id = "mce_0_ifr")
	WebElement frame;
	@FindBy(css = ".tox-button")
	WebElement cross;
	@FindBy(id = "tinymce")
	WebElement contbox;

	public IframePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean iframeopen() {
		String typedmsg = "My name is Raman";

		cross.click();
		driver.switchTo().frame(frame);
		contbox.clear();
		contbox.sendKeys(typedmsg);
		String framemsg = contbox.getText();

		if (framemsg.trim().equals(typedmsg.trim()))
			return true;
		else {
			return false;
		}

	}

}
