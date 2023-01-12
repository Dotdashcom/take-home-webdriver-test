package staffitsolution.qa.wlctointernet.test;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import staffitsolution.qa.wlctointernet.Base.BaseTest;

public class NewTabTest extends BaseTest{
	@Test
	public void newTabTest() throws InterruptedException 
	{
		driver.get(prop.getProperty("newtaburl"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	      //switch to new tab
	      driver.switchTo().window(newTb.get(1));
	 	      String Title=driver.getTitle();
	 	     System.out.println("Page title of new tab: " + Title);
	      //switch to parent window
	      driver.switchTo().window(newTb.get(0));
	      System.out.println("Page title of parent window: " + driver.getTitle());
	      Assert.assertEquals(Title, "New Window");
	      
	      
}
}