package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DragAndDropPO {

	WebDriver driver;
			
	public DragAndDropPO(WebDriver driver) {
		this.driver= driver;
	}
	
	public void draganddrop() 
	{
		try {
		WebElement A= driver.findElement(By.id("column-a"));
		WebElement B= driver.findElement(By.id("column-b"));
		
		Actions action= new Actions(driver);
		action.dragAndDrop(A, B).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Assert.assertEquals(driver.findElement(By.id("column-a")).getText(),"B");
		 }
		catch (Exception e) {
	System.out.println(e.getMessage());}
		}
	}

	

