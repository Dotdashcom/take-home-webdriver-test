package dotdash.pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WindowsPage {

public WebDriver driver;
	
	

	@FindBy(xpath="//div[@class='example']/a")
	private WebElement clickHere;
	
	@FindBy(xpath="//div[@class='example']/h3")
	private WebElement newWindowText;
	
	
	public WindowsPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void navigateToNewWindowAndVerifyText(String text)  {
		clickHere.click();
		Set<String> windows= driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		newWindowText.isDisplayed();
		Assert.assertTrue((newWindowText.getText()).equals(text)); 
	}
}
