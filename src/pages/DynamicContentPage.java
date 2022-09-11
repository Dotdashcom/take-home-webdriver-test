package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Util.TestBase;

public class DynamicContentPage extends TestBase{

	@FindBy(xpath="//div[2]/div[2]")
	WebElement SecondRowText;
	@FindBy(xpath="//div[2]/div[1]/img[1]")
	WebElement SecondRowImg;
	
	public void Initialization(){
		browserInitialization();
		PageFactory.initElements(driver, this);
	}
	public void landingPage() {
		driver.get(BaseUrl+"/dynamic_content");	
	}
	public void refreshPage() {
		driver.navigate().refresh();
	}
	public String getSecondRowText() {
		return SecondRowText.getText();
	}
	public String getSecondRowImg() {
		return SecondRowImg.getAttribute("src");
	}
	public void closeBrowser() {
		driver.quit();
	}
	
	
}
