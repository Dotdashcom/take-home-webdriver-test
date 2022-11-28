package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import junit.framework.Assert;
 
public class TC_DynamicControl extends BaseClass{ 



	@Test(priority = 1)	
	public void VerifyCheckboxIsRemoved() throws InterruptedException {

		String url = driver.getCurrentUrl();
		driver.get(url + "/dynamic_controls");
		WebElement buttonremove=driver.findElement(By.cssSelector("#checkbox-example button"));
		driver.findElement(By.xpath("//*[@id=\"checkbox\"]"));
		buttonremove.click();
		WebDriverWait wait = new WebDriverWait(driver, 7);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[@id=\"checkbox\"]"))));
		if(driver.findElements(By.xpath("//*[@id=\"checkbox\"]")).isEmpty()){
			Assert.assertTrue(true);
			System.out.println("CheckBox is Removed");
			Thread.sleep(5000);
		}else{
			Assert.assertTrue(false);	
			System.out.println("CheckBox is not Removed");
		}
	}
	@Test	(priority = 2)			 
	public void VerifyCheckboxAddedBack() {


		driver.get("http://localhost:7080/dynamic_controls");
		WebElement buttonremove=driver.findElement(By.cssSelector("#checkbox-example button"));
		driver.findElement(By.xpath("//*[@id=\"checkbox\"]"));
		buttonremove.click();
		WebDriverWait wait = new WebDriverWait(driver, 7);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[@id=\"checkbox\"]"))));
		buttonremove.click();
		WebDriverWait waits = new WebDriverWait(driver, 7);
		waits.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"checkbox\"]"))));
		if(!driver.findElements(By.xpath("//*[@id=\"checkbox\"]")).isEmpty()){
			Assert.assertTrue(true);
			System.out.println("CheckBox is Added Back");
		}else{
			Assert.assertTrue(false);	
			System.out.println("CheckBox is not Added");
		}
	}
	
	@Test(priority = 3)	
		public void VerifyTextBoxisEnabled() {


			driver.get("http://localhost:7080/dynamic_controls");
			WebElement enable=driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
			WebElement textbox= driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
			enable.click();
			WebDriverWait wait = new WebDriverWait(driver, 7);
			wait.until(ExpectedConditions.elementToBeClickable(textbox));
			
			if(textbox.isEnabled()) {
				Assert.assertTrue(true);	
				System.out.println("Textbox is Enabled");
			}
			
			else{
				Assert.assertTrue(false);	
				System.out.println("Textbox is not Enabled");
			}

	}		
			
			@Test(priority = 4)	
			public void VerifyTextBoxisDisabled() throws InterruptedException {

				
				driver.get("http://localhost:7080/dynamic_controls");
				
				
				By button = By.xpath("//*[@id=\"input-example\"]/button");
				By textbox = By.xpath("//*[@id=\"input-example\"]/input");
				By message = By.xpath("//*[@id=\"message\"]");
				driver.findElement(button).click();
				WebDriverWait waitsd = new WebDriverWait(driver, 10);
				waitsd.until(ExpectedConditions.elementToBeClickable(textbox));
				
				
				driver.findElement(button).click();
				waitsd.until(ExpectedConditions.textToBe(message,"It's disabled!"));
				
				if(driver.findElement(textbox).isEnabled())
				{
					Assert.assertTrue(false);	
					System.out.println("Textbox is not Disabled");
				}
				else 
				{
					Assert.assertTrue(true);	
					System.out.println("Textbox is Disabled");
				
				}
				

	}		

}
