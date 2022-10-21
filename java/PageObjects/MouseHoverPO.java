package PageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverPO {

	WebDriver driver;
	public MouseHoverPO(WebDriver driver) {
		this.driver= driver;
	}
		
	public void mouseHover() throws InterruptedException  {
			
		Actions action= new Actions(driver);
		
		Thread.sleep(2000);
		
		WebElement target1 = driver.findElement(By.xpath("//img[@alt='User Avatar'] [1]"));
		action.moveToElement(target1).build().perform();
		
		WebElement target2 = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[2]"));
		action.moveToElement(target2).perform();
		
		WebElement target3 = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[3]"));
		action.moveToElement(target3).perform();
		
		String Text= driver.findElement(By.xpath("(//h5)[1]")).getText();
		
		assertTrue(Text.contains(Text));
	}

	}
	


