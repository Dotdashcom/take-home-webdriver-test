package dotdash.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class IframePage {

public WebDriver driver;
	
	

	@FindBy(id="tinymce")
	private WebElement textField;
	
	
	
	public IframePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void switchToFrameAndType(String text)  {
		if((driver.findElements(By.xpath("//div[@role='alert']/button"))).size()>0)
		driver.findElement(By.xpath("//div[@role='alert']/button")).click();
		driver.switchTo().frame("mce_0_ifr");
		textField.clear();
		textField.sendKeys(text);
		Assert.assertTrue((textField.getText()).equals(text));
	}

}
