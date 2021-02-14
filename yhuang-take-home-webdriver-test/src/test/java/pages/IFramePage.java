package pages;

import org.openqa.selenium.*;

public class IFramePage extends BaseDriver{
	public IFramePage(WebDriver driver){
        super(driver);
    }
	
	public String switchIFrameAndEnterText(String text) {
		driver.switchTo().frame("mce_0_ifr");
		WebElement inputBox = driver.findElement(By.id("tinymce"));
		inputBox.clear();
		inputBox.sendKeys(text);
		return inputBox.getText();
	}
}
