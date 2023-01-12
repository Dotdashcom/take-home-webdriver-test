package staffitsolution.qa.wlctointernet.test;

import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import staffitsolution.qa.wlctointernet.Base.BaseTest;

public class MouseHoverTest extends BaseTest{
	@Test
	public void mouseHoverTest() throws InterruptedException 
	{
		driver.get(prop.getProperty("mousehoverurl"));
		Thread.sleep(2000);

		
		System.out.println("1st image");
        WebElement ele = driver.findElement(By.xpath("(//div[@class='figure'])[1]"));
		Actions act= new Actions(driver);
		act.moveToElement(ele).perform();
		
		WebElement subMenu = driver.findElement(By.xpath("(//h5)[1]"));
		String text=subMenu.getText();
		System.out.println("First image text is:" + text);
		Assert.assertEquals(text, "name: user1");

		//---------------- 2nd image
		System.out.println("2nd image");
		WebElement ele1 = driver.findElement(By.xpath("(//div[@class='figure'])[2]"));
		Actions act1= new Actions(driver);
		act1.moveToElement(ele1).perform();
		
		WebElement subMenu1 = driver.findElement(By.xpath("(//h5)[2]"));
		String text1=subMenu1.getText();
		System.out.println("Second image text is:" + text1);
		Assert.assertEquals(text1, "name: user2");
		
		//---------------- 3rd image
				System.out.println("3rd image");
				WebElement ele2 = driver.findElement(By.xpath("(//div[@class='figure'])[3]"));
				Actions act2= new Actions(driver);
				act2.moveToElement(ele2).perform();
				
				WebElement subMenu2 = driver.findElement(By.xpath("(//h5)[3]"));
				String text2=subMenu2.getText();
				System.out.println("Third image text is:" + text2);
				Assert.assertEquals(text2, "name: user3");
}
}
