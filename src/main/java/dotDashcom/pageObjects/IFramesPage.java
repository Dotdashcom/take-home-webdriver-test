package dotDashcom.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IFramesPage {
	WebDriver driver;

	public IFramesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="mce_0_ifr")
	private WebElement iFrame;
	
	@FindBy(xpath="//body[@id='tinymce']/p")
	private WebElement textBox;
	
	public void switchAndTypeText(String text) {
		driver.switchTo().frame(iFrame);
		textBox.clear();
		textBox.sendKeys(text);
	}
	public String verifyText() {
		String iFrameText=textBox.getText();
		return iFrameText;
	}
}
