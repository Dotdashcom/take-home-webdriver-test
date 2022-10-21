package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DynamicContentPO {

	WebDriver driver;
		
	public DynamicContentPO(WebDriver driver) {
		this.driver= driver;
	}
		
	public void dynamicContent()
	{
			WebElement content= driver.findElement(By.id("content"));
			content.getText();
			driver.navigate().refresh();
			WebElement refreshcontent1= driver.findElement(By.id("content"));
		    refreshcontent1.getText();
		    driver.navigate().refresh();
		    WebElement refreshcontent2= driver.findElement(By.id("content"));
		    refreshcontent2.getText();
			Assert.assertNotEquals(refreshcontent1, refreshcontent2);		
	}

	
	}
	


