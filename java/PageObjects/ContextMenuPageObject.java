package PageObjects;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPageObject {

	WebDriver driver;
		
	public ContextMenuPageObject(WebDriver driver) {
		this.driver= driver;
	}
			
	public void contextmenu()
	{
		WebElement textbox= driver.findElement(By.id("hot-spot"));
		Actions action= new Actions(driver);
		
		action.contextClick(textbox).perform();
	}
	
	public void validatetext() throws InterruptedException 
	{
		try
		{Alert alert= driver.switchTo().alert();
		String text1=alert.getText();
		assertEquals(text1, "the-internet");
		Thread.sleep(2000);
		alert.accept();
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		}
}

	 


