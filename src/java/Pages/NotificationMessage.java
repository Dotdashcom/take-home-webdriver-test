package java.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class NotificationMessage {

	
	WebDriver driver;
	
	public NotificationMessage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//a[contains(text(),'Click here')]")
	WebElement clickHere;
	
	@FindBy(xpath = "//div[@id='flash']")
	WebElement notificationMessage;
	
	
	
	public void clickForNotification()
	{
		
		for(int i=1; i<9; i++)
		{
			clickHere.click();
			
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='flash']")));
			
			System.out.println(notificationMessage.getText());
			
			
			if(notificationMessage.getText().equals("Action unsuccesful, please try again"))
			{
				Assert.assertEquals(notificationMessage.getText(), "Action unsuccesful, please try again");
			}
			else if(notificationMessage.getText().equals("Action successful"))
			{
				Assert.assertEquals(notificationMessage.getText(), "Action successful");
			}
			
			
		}
		
		
		
		
		
	}
	
	
	
	
}
