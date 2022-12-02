package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class IFramePage {

	WebDriver driver;
	private String innerText;

	public IFramePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Elements or locators
	@FindBy(css = "#tinymce > p")
	WebElement iFrameBody;

	public void writeToIframe(String text) {
		driver.switchTo().frame("mce_0_ifr");
		iFrameBody.clear();
		iFrameBody.sendKeys(text);
		innerText = iFrameBody.getText();
	}

	public String getText() {
		return innerText;
	}

	// get url
	public IFramePage getUrl() {
		driver.navigate().to(TestBase.url + "/iframe");
		return this;
	}
}
