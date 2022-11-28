package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class IFrames {

	WebDriver driver;
	public IFrames(WebDriver d)
	{
		driver = d;
		PageFactory.initElements(d, this);
	}
	@FindBy(id = "mce_0_ifr")
	WebElement iframe;
	@FindBy(id = "tinymce")
	WebElement iframebody;

	public void WritetoIframe(String message){

		driver.switchTo().frame(iframe);
		iframebody.clear();
		iframebody.sendKeys(message);
		Assert.assertEquals(message, iframebody.getText());
	}
}

