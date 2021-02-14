package pages;

import java.util.Iterator;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class OpenNewTabPage extends BaseDriver{
	public OpenNewTabPage(WebDriver driver){
        super(driver);
    }
	
	@FindBy(xpath="//a[@href='/windows/new']")
	public WebElement clickHereLnk;
	
	public String getTextFromNewTab() throws InterruptedException {
		clickHereLnk.click();
		Thread.sleep(6000);
		
		Iterator<String> tabIterator = driver.getWindowHandles().iterator();
		String parentTab = tabIterator.next();
		String childTab = tabIterator.next();
		driver.switchTo().window(childTab);
		Thread.sleep(6000);
		
		String text = driver.findElement(By.tagName("h3")).getText();
		driver.switchTo().window(parentTab);
		return text;
	}
}
