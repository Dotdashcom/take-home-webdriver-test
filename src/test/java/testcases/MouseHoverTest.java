package testcases;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestBase;

public class MouseHoverTest extends TestBase{
	
	public MouseHoverTest() throws IOException {
		super();	
	}
	
	@Test  
	public void verifyMouseHover() throws InterruptedException
	{
		driver.get(urlvalues.url_hover);
		Actions actions = new Actions(driver);
		int i=0;
		for(WebElement element : data.mousehover)
		{
			//handle the mousehover using Actions's class 
			actions.moveToElement(element).build().perform();
			Thread.sleep(2000);	
			Assert.assertTrue(data.additionallist.get(i).isDisplayed());
			System.out.println(data.additionallist.get(i).getText());		
			i++;
		}
		System.out.println("text is displayed as per image selected");
	}
}
