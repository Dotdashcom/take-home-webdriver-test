package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TC_DynamicLoading extends BaseClass {
	
	@Test
	public void VerifyDynamicLoading() throws InterruptedException {

		
		driver.get("http://localhost:7080/dynamic_loading/2");
		
		
		By start = By.xpath("//*[@id=\"start\"]/button");
		By message = By.xpath("//*[@id=\"finish\"]/h4");
		driver.findElement(start).click();
		WebDriverWait waitsd = new WebDriverWait(driver, 10);
		waitsd.until(ExpectedConditions.presenceOfElementLocated(message));
		
		if(driver.findElement(message).isDisplayed())
		{
			System.out.println(driver.findElement(message).getText());
			Assert.assertEquals("Hello World!",driver.findElement(message).getText());	
			System.out.println("Text is displayed");
		}
		

}		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
