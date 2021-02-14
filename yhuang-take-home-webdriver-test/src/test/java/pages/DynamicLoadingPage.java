package pages;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class DynamicLoadingPage extends BaseDriver{
	public DynamicLoadingPage(WebDriver driver){
        super(driver);
    }
	
	@FindBy(css="div#start button")
	public WebElement StartBtn;
	
	public String getDisplayTextAfterStartButtonClick() throws InterruptedException{
		StartBtn.click();
		Thread.sleep(3000);
		List<WebElement> elementList = driver.findElements(By.cssSelector("div#finish h4"));
		if(elementList.isEmpty())
			return "";
		return elementList.get(0).getText();
	}
}
