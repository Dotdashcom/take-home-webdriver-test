package Test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Util.BrowserFactory;

public class MouseHoverTest extends BrowserFactory{

	@Before
    public void Setup()
	{
		startBrowser();
		driver.get(" http://localhost:7080/hovers");
	}
    @Test 
    public void Verify_AdditionalInfoDisplyedWhenHoverOver() throws Exception
    {
		// elements for images
		WebElement User1 = driver.findElement(By.xpath("//div[@class='figure'][1]/img"));
		WebElement User2 = driver.findElement(By.xpath("//div[@class='figure'][2]/img"));
		WebElement User3 = driver.findElement(By.xpath("//div[@class='figure'][3]/img"));

		//act
		Actions action = new Actions(driver);
		action.moveToElement(User1).perform();
		
		// Verify
		WebElement name1 = driver.findElement(By.xpath("//div[@class='figure'][1]//descendant::h5"));
		WebElement profilelinke1 = driver.findElement(By.xpath("//div[@class='figure'][1]//descendant::a"));

		assertTrue(name1.isDisplayed()&&profilelinke1.isDisplayed());
		
		
		//act
		action.moveToElement(User2).perform();	
		
		// Verify
		WebElement name2 = driver.findElement(By.xpath("//div[@class='figure'][2]//descendant::h5"));
		WebElement profilelinke2 = driver.findElement(By.xpath("//div[@class='figure'][2]//descendant::a"));

		assertTrue(name2.isDisplayed()&&profilelinke2.isDisplayed());
		
		//act
		action.moveToElement(User3).perform();
		
		// Verify
		WebElement name3 = driver.findElement(By.xpath("//div[@class='figure'][3]//descendant::h5"));
		WebElement profilelinke3 = driver.findElement(By.xpath("//div[@class='figure'][3]//descendant::a"));

		assertTrue(name3.isDisplayed()&&profilelinke3.isDisplayed());
   
    }
    
    @After 
    public void tearDown() 
    {
    	closeBrowser();
    }

}
